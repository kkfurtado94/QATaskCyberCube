package step_definitions;

import com.codeborne.selenide.Condition;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import pageobjects.CartCheckoutPage;
import pageobjects.LoginPage;
import utils.EnvironmentVariables;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class LoginSteps {
    LoginPage loginPage = new LoginPage();
    CartCheckoutPage cp = new CartCheckoutPage();

    @Given("User navigates to the SauceDemo login page")
    @Step("User navigates to the SauceDemo login page")
    public void userNavigatesToTheSauceDemoLoginPage() {
        open(EnvironmentVariables.UI_URL);
    }

    @Then("the user should be seeing the home page")
    @Step("the user should be seeing the home page")
    public void theUserShouldBeSeeingTheHomePage() {
        loginPage.getInventoryContainer().shouldBe(Condition.visible);
        webdriver().shouldHave(url("https://www.saucedemo.com/inventory.html"));
    }

    @When("the user logs in with {string} and {string}")
    @Step("the user logs in with {string} and {string}")
    public void theUserLogsInWithAnd(String username, String password) {
        loginPage.setUsername(username);
        loginPage.setPassword(password);
        loginPage.loginButton().click();
    }

    @Then("the user should be seeing the locked out message")
    @Step("the user should be seeing the locked out message")
    public void theUserShouldBeSeeingTheLockedOutMessage() {
        loginPage.fetchLoginErrorMessage().shouldHave(text("Epic sadface: Sorry, this user has been locked out."));
    }

    @Then("the user should be seeing the Password and Username not matching message")
    @Step("the user should be seeing the Password and Username not matching message")
    public void theUserShouldBeSeeingTheUsernamePasswordNotMatch() {
        loginPage.fetchLoginErrorMessage().shouldHave(text("Epic sadface: Username and password do not match any user in this service"));
    }

    @Then("the user should be seeing the Username is required message")
    @Step("the user should be seeing the Username is required message")
    public void theUserShouldBeSeeingTheUsernameIsRequiredMessage() {
        loginPage.fetchLoginErrorMessage().shouldHave(text("Epic sadface: Username is required"));
    }

    @Then("the user should be seeing the Password is required message")
    @Step("the user should be seeing the Password is required message")
    public void theUserShouldBeSeeingThePasswordIsRequiredMessage() {
        loginPage.fetchLoginErrorMessage().shouldHave(text("Epic sadface: Password is required"));
    }

    @When("user attempts to log out")
    @Step("user attempts to log out")
    public void userAttemptsToLogOut() {
        loginPage.fetchMenuButton().click();
        loginPage.fetchLogoutButton().click();
    }

    @When("navigates back to the previous page")
    @Step("navigates back to the previous page")
    public void navigatesBackToPreviousPage() {
        back();
    }

    @Then("the user is back to the login page")
    @Step("the user is back to the login page")
    public void theUserIsBackToTheLoginPage() {
        loginPage.loginButton().shouldBe(Condition.visible);
        webdriver().shouldHave(url("https://www.saucedemo.com/"));
    }

    @Then("the user should be seeing the Invalid Access to Inventory message")
    @Step("the user should be seeing the Invalid Access to Inventory message")
    public void theUserShouldBeSeeingTheInvalidAccessToInventoryMessage() {
        loginPage.fetchLoginErrorMessage().shouldHave(text("Epic sadface: You can only access '/inventory.html' when you are logged in."));
    }

    @When("user will add a backpack to the cart")
    @Step("user will add a backpack to the cart")
    public void userWillAddABackpackToTheCart() {
        cp.addBackPack().click();
    }

    @Then("the cart should be empty")
    @Step("the cart should be empty")
    public void theCartShouldBeEmpty() {
        open("https://www.saucedemo.com/cart.html");
        loginPage.fetchCartItem().shouldNotBe(visible);
    }


}
