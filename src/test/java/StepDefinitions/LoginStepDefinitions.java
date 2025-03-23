package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BasePage;
import pages.ProductStorePage;
import pages.LoginPage;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginStepDefinitions {
    Logger logger = Logger.getLogger(this.getClass().getName());
    LoginPage loginPage;
    ProductStorePage productStorePage;

    @Given("user visits the websites")
    public void user_visits_the_websites() {
        BasePage.initDriver().get("https://www.demoblaze.com");
    }

    @When("user navigates to the login page and enter username {string} and password {string}")
    public void userEnterUsernameAndPassword(String username, String password) {
        loginPage = new LoginPage();
        loginPage.doLogin(username, password);
    }

    @Then("user can view the product store page")
    public void user_can_view_the_product_store_page() {
        logger.log(Level.FINE,"user_can_view_the_product_store_page ########################");
        productStorePage = new ProductStorePage();
        productStorePage.userInProductStore();
    }

    @Then("user can't view the product store page")
    public void userCanTViewTheProductPage() {
        loginPage.assertingErrorMessage();
    }

    @When("user navigates to the login page and leave the username and password fields empty")
    public void userNavigatesToTheLoginPageAndLeaveTheUsernameAndPasswordFieldsEmpty() {
        //System.out.println("Property--------------->"+System.getProperty("siteURL"));
        BasePage.initDriver().get(System.getProperty("siteURL"));//"https://www.demoblaze.com");
    }

    @And("user click the LogIn button")
    public void userClickTheButton() {
        loginPage = new LoginPage();
        loginPage.clickLogin();
    }

    @Then("user should see an error message {string}")
    public void userShouldSeeAnErrorMessage(String arg0) {
        loginPage.assertingEmptyFieldErrorMessage(arg0);
    }

    @And("browser closes")
    public void browserCloses() {
        BasePage.getDriver().quit();
    }
}
