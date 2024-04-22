package step_definitions;

import io.cucumber.java.en.Then;
import io.qameta.allure.Step;
import pageobjects.ProductPage;

public class ProductSteps {
    ProductPage prodPage = new ProductPage();

    @Then("the user should be seeing the list of products available")
    @Step("the user should be seeing the list of products available")
    public void theUserShouldBeSeeingTheListOfProducts() {
        System.out.println("--------------------------------------------");

        String [] itemDetailNames = {"name","description","price","button text"};
        String [] itemDetailsReceived;
        String [][] itemDetailsCorrect = {
                {"Sauce Labs Backpack", "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.","$29.99","Add to cart"},
                {"Sauce Labs Bike Light", "A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included.","$9.99","Add to cart"},
                {"Sauce Labs Bolt T-Shirt","Get your testing superhero on with the Sauce Labs bolt T-shirt. From American Apparel, 100% ringspun combed cotton, heather gray with red bolt.","$15.99","Add to cart"},
                {"Sauce Labs Fleece Jacket", "It's not every day that you come across a midweight quarter-zip fleece jacket capable of handling everything from a relaxing day outdoors to a busy day at the office.","$49.99","Add to cart"},
                {"Sauce Labs Onesie","Rib snap infant onesie for the junior automation engineer in development. Reinforced 3-snap bottom closure, two-needle hemmed sleeved and bottom won't unravel.","$7.99","Add to cart"},
                {"Test.allTheThings() T-Shirt (Red)","This classic Sauce Labs t-shirt is perfect to wear when cozying up to your keyboard to automate a few tests. Super-soft and comfy ringspun combed cotton.","$15.99","Add to cart"},
        };

        System.out.println("Number of product items :" + prodPage.fetchProductsList().size());

        for (int i=0; i<=5; i++) {
            itemDetailsReceived = prodPage.fetchProductsList().get(i).getText().split("\\R");
            for (int j=0; j<=3; j++) {
                if(itemDetailsCorrect[i][j].equals(itemDetailsReceived[j]) ) {
                    System.out.println("Product "+(i+1)+ " "+itemDetailNames[j] +" is correct: "+ itemDetailsReceived[j] );
                }
                else {
                    System.out.println("Product "+(i+1)+ " "+itemDetailNames[j] +" is wrong: "+ "Received --> "+itemDetailsReceived[j]+" Expected --> "+itemDetailsCorrect[i][j] );
                }
            }
        }


    }
}
