package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefinitions {

    @Given("user visits the websites")
    public void user_visits_the_websites() {
    }

    @When("user navigates to the login page and enter username {string} and password {string}")
    public void userEnterUsernameAndPassword(String username, String password) {
    }

    @Then("user can view the product store page")
    public void user_can_view_the_product_store_page() {
    }

    @Then("user can't view the product store page")
    public void userCanTViewTheProductPage() {
    }

    @And("user click the LogIn button")
    public void userClickTheButton() {
    }

    @And("browser closes")
    public void browserCloses() {
    }

}
