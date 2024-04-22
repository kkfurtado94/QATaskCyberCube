package pageobjects;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$$;

public class ProductPage {

    private static final By PRODUCT_LIST = By.xpath("/html/body/div/div/div/div[2]/div/div/div/div");
//    private static final By PRODUCT_LIST = By.id("inventory_container");

    public ElementsCollection fetchProductsList(){
        return $$(PRODUCT_LIST);
    }
}
