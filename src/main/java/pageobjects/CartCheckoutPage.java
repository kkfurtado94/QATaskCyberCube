package pageobjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CartCheckoutPage {
    private static final By NAME = By.xpath("//*[@data-test=\"firstName\"]");
    private static final By LAST_NAME = By.xpath("//*[@data-test=\"lastName\"]");
    private static final By POSTAL_CODE = By.xpath("//*[@data-test=\"postalCode\"]");
    private static final By CONTINUE_BUTTON = By.xpath("//*[@data-test=\"continue\"]");
    private static final By FINISH_BUTTON = By.xpath("//*[@data-test=\"finish\"]");
    private static final By MESSAGE_PURCHASE = By.xpath("//*[@data-test=\"complete-text\"]");
    private static final By CART_LINK = By.xpath("//*[@data-test=\"shopping-cart-link\"]");
    private static final By CHECKOUT = By.xpath("//*[@data-test=\"checkout\"]");
    private static final By CHECKOUT_PAGE = By.xpath("//*[@data-test=\"checkout-info-container\"]");
    private static final By ADD_BACKPACK = By.xpath("//*[@data-test=\"add-to-cart-sauce-labs-backpack\"]");
    private static final By CARD_BADGE = By.xpath("//*[@data-test=\"shopping-cart-badge\"]");

    public SelenideElement setName(String name) {
        return $(NAME).setValue(name);
    }
    public SelenideElement setLastName(String lastName) {
        return $(LAST_NAME).setValue(lastName);
    }
    public SelenideElement setPostalCode(String postalCode) {
        return $(POSTAL_CODE).setValue(postalCode);
    }
    public SelenideElement continueButton() {
        return $(CONTINUE_BUTTON);
    }
    public SelenideElement badgeContainer() {
        return $(CARD_BADGE);
    }
    public SelenideElement addBackPack() {
        return $(ADD_BACKPACK);
    }
    public SelenideElement checkoutPage() {
        return $(CHECKOUT_PAGE);
    }
    public SelenideElement checkout() {
        return $(CHECKOUT);
    }
    public SelenideElement cartLink() {
        return $(CART_LINK);
    }
    public SelenideElement purchaseOk() {
        return $(MESSAGE_PURCHASE);
    }
    public SelenideElement finishButton() {
        return $(FINISH_BUTTON);
    }



}
