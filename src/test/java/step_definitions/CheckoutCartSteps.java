package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import pageobjects.CartCheckoutPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

public class CheckoutCartSteps {

    CartCheckoutPage cp = new CartCheckoutPage();
    
    @And("checks if the cart badge is updated")
    @Step("checks if the cart badge is updated")
    public void checksIfTheCartBadgeIsUpdated() {
        cp.badgeContainer().shouldHave(text("1"));
        
    }

    @And("user goes to the cart")
    @Step("user goes to the cart")
    public void userGoesToTheCart() {
        cp.cartLink().click();
    }

    @When("user clicks on checkout")
    @Step("user clicks on checkout")
    public void userClicksOnCheckout() {
        cp.checkout().click();
    }

    @And("user is on checkout page")
    @Step("user is on checkout page")
    public void userIsOnCheckoutPage() {
        cp.checkoutPage().shouldBe(visible);
    }

    @And("fills in his data {string} and {string} and {string} and press continue")
    @Step("fills in his data {string} and {string} and {string} and press continue")
    public void fillsInHisDataAndAndAndPressContinue(String name, String lastName, String postalCode) {
        cp.setName(name);
        cp.setLastName(lastName);
        cp.setPostalCode(postalCode);
        cp.continueButton().click();
        cp.finishButton().click();
    }

    @Then("the user should see the purchase completed message")
    @Step("the user should see the purchase completed message")
    public void theUserShouldSeeThePurchaseCompletedMessage() {
        cp.purchaseOk().shouldHave(text("Your order has been dispatched, and will arrive just as fast as the pony can get there!"));
    }

    @And("user adds a backpack to the cart")
    @Step("user adds a backpack to the cart")
    public void userAddsABackpackToTheCart() {
        cp.addBackPack().click();
    }
}
