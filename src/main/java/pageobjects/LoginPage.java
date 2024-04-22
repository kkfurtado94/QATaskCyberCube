package pageobjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    private static final By USERNAME_FIELD_ID = By.xpath("//*[@data-test=\"username\"]");
    private static final By PASSWORD_FIELD_ID = By.xpath("//*[@data-test=\"password\"]");
    private static final By LOGIN_BUTTON_ID = By.xpath("//*[@data-test=\"login-button\"]");
    private static final By INVENTORY_FORM_ID = By.xpath("//*[@data-test=\"inventory-container\"]");
    private static final By LOCKED_OUT_MESSAGE = By.xpath("//*[@data-test=\"error\"]");
    private static final By SANDWICH_MENU = By.id("react-burger-menu-btn");
    private static final By LOGOUT_BUTTON = By.xpath("//*[@data-test=\"logout-sidebar-link\"]");
    private static final By CART_INVENTORY = By.xpath("//*[@data-test=\"inventory-item\"]");

    public SelenideElement setUsername(String user) {
        return $(USERNAME_FIELD_ID).setValue(user);
    }

    public SelenideElement setPassword(String password) {
        return $(PASSWORD_FIELD_ID).setValue(password);
    }

    public SelenideElement loginButton() {
        return $(LOGIN_BUTTON_ID);
    }

    public SelenideElement getInventoryContainer() {
        return $(INVENTORY_FORM_ID);
    }

    public SelenideElement fetchLoginErrorMessage() {
        return $(LOCKED_OUT_MESSAGE);
    }

    public SelenideElement fetchMenuButton() {
        return $(SANDWICH_MENU);
    }

    public SelenideElement fetchLogoutButton(){
        return $(LOGOUT_BUTTON);
    }
    public SelenideElement fetchCartItem(){
        return $(CART_INVENTORY);
    }
}
