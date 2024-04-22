package step_definitions;

import api.BaseRestApi;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

public class PetAPISteps {
    String petId = "";
    String petStatus = "";
    BaseRestApi api;
    Scenario scenario;

    @Before("@api")
    public void beforeApi(Scenario scenario) {
        this.scenario = scenario;
        api = new BaseRestApi();
    }

    @After("@api")
    public void afterApi() {
        petId = "";
        petStatus = "";
    }

    @When("user searches for pets by {string}")
    @Step("user searches for pets by {string}")
    @DisplayName("-------------------")
    public void searchByStatus(String status) {
        scenario.log("GET pet with " + status + " status");
        Response getResponse = api.PetGETByStatus(status);

        scenario.log("GET pet response: " + getResponse.body().jsonPath().getString("[0]"));
        Assertions.assertTrue(getResponse.statusCode() == 200, "Unable to GET Pet by Status: " + status);

        String isAvailable = getResponse.body().jsonPath().getString("[0].status");
        Assertions.assertEquals(status, isAvailable, "Pet Status is not as expected");
    }

    @When("user creates a new pet with status as {string}")
    @Step("user creates a new pet with status as {string}")
    public void creates_a_new_pet_with_status_as(String status) {
        new JSONObject();
        JSONObject testdataPOST;
        testdataPOST = TestData.CreatePetPayload(status);
        scenario.log("POST pet request: " + testdataPOST.toString());

        Response postResponse = api.PetPOST(testdataPOST.toString());
        scenario.log("POST pet response: " + postResponse.prettyPrint());
        Assertions.assertTrue(postResponse.statusCode() == 200, "Unable to CREATE new pet");

        String expectedId = testdataPOST.getString("id");
        String actualId = postResponse.body().jsonPath().getString("id");
        Assertions.assertEquals(expectedId, actualId, "ID doesn't match in response");
        petId = actualId;

        String expectedName = testdataPOST.getString("name");
        String actualName = postResponse.body().jsonPath().getString("name");
        Assertions.assertEquals(expectedName, actualName, "NAME doesn't match in response");

        String expectedStatus = testdataPOST.getString("status");
        String actualStatus = postResponse.body().jsonPath().getString("status");
        Assertions.assertEquals(expectedStatus, actualStatus, "STATUS doesn't match in response");
        petStatus = actualStatus;
    }

    @And("check for pet details")
    @Step("check for pet details")
    public void verify_pet_details() {
        scenario.log("GET pet " + petId + " details");
        Response postResponse = api.PetGET(petId);
        scenario.log("GET pet details response: " + postResponse.prettyPrint());
        Assertions.assertTrue(postResponse.statusCode() == 200, "Unable to GET pet details: " + petId);

        String id = postResponse.body().jsonPath().getString("id");
        Assertions.assertEquals(petId, id, "Body {id} is not as expected");

        String actualStatus = postResponse.body().jsonPath().getString("status");
        Assertions.assertEquals(petStatus, actualStatus, "Body {status} is not as expected" );
    }

    @When("user updates the pet status to {string}")
    @Step("user updates the pet status to {string}")
    public void updates_the_pet_status_to(String status) {
        scenario.log("Update pet with status: " + status);
        Response postResponse = api.PetPOSTUpdateStatus(petId, status);
        scenario.log("Updated pet details response: " + postResponse.prettyPrint());
        Assertions.assertTrue(postResponse.statusCode() == 200, "Unable to UPDATE status for pet: " + petId);

        String code = postResponse.body().jsonPath().getString("code");
        Assertions.assertEquals("200", code, "Body {code} is not as expected");

        String message = postResponse.body().jsonPath().getString("message");
        Assertions.assertEquals(petId, message, "Body {message} is not as expected");
        petStatus = status;
    }

    @Then("user deletes the pet")
    @Step("user deletes the pet")
    public void deletes_the_pet() {
        scenario.log("Delete pet: " + petId);
        Response deleteResponse = api.PetDELETE(petId);
        Assertions.assertTrue(deleteResponse.statusCode() == 200, "Unable to DELETE pet: " + petId);

        String code = deleteResponse.body().jsonPath().getString("code");
        Assertions.assertEquals("200", code, "Body {code} is not as expected");

        String message = deleteResponse.body().jsonPath().getString("message");
        Assertions.assertEquals(petId, message, "Body {message} is not as expected");
    }

    @And("user completes the test validating if the pet is deleted")
    @Step("user completes the test validating if the pet is deleted")
    public void verify_pet_is_deleted() {
        Response postResponse = api.PetGET(petId);
        Assertions.assertTrue(postResponse.statusCode() == 404, "Pet is not deleted: " + petId);
    }
}
