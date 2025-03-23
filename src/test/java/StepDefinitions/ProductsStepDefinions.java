package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BasePage;
import pages.ProductPage;
import pages.ProductStorePage;

public class ProductsStepDefinions {
    ProductStorePage productStorePage;
    ProductPage productPage;

    @Given("User is on home page")
    public void user_visits_the_websites() {
        BasePage.initDriver().get(System.getProperty("siteURL"));
    }

    @When("User press home tab")
    public void userPressHomeTab() {
        productStorePage = new ProductStorePage();
        productStorePage.clickHomeTab();
    }

    @And("User selects first product")
    public void userSelectsFirstProduct() {
        productStorePage.clickFirstProduct();
    }

    @Then("User clicks on Add to Cart button")
    public void userClicksOnAddToCartButton() {
        productPage = new ProductPage();
        productPage.clickAddToCartProduct();
    }

    @And("Alert message popups Product Added")
    public void alertMessagePopups() {
        productPage.assertingProductAddedMessage();
    }

    @And("Browser closes")
    public void browserCloses() {
        BasePage.getDriver().quit();
    }
}
