package pages;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    @FindBy (id = "login2")
    WebElement loginNavigate;

    @FindBy (id = "loginusername")
    WebElement usernameField;

    @FindBy (id= "loginpassword")
    WebElement passwordField;

    @FindBy(xpath = "//button[@onclick='logIn()']")
    WebElement loginButton;

    public LoginPage(){
        PageFactory.initElements(driver, this);
    }
    //User does not exist.
    public void doLogin(String username, String password){
        wait.until(ExpectedConditions.visibilityOf(loginNavigate)).click();
        wait.until(ExpectedConditions.visibilityOf(usernameField)).sendKeys(username);
        wait.until(ExpectedConditions.visibilityOf(passwordField)).sendKeys(password);
        wait.until(ExpectedConditions.visibilityOf(loginButton)).click();
    }

    public void clickLogin(){
        wait.until(ExpectedConditions.visibilityOf(loginNavigate)).click();
        wait.until(ExpectedConditions.visibilityOf(loginButton)).click();
    }

    public void assertingErrorMessage(){
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();

        // Error message
        String alertText = alert.getText();
        System.out.println("Alert message: " + alertText);
        Assert.assertTrue(alertText.contains("User does not exist.") || alertText.contains("Wrong password."));
        // Close alert (ОК)
        alert.accept();
    }

    public void assertingEmptyFieldErrorMessage(String errStr){
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();

        // Error message
        String alertText = alert.getText();
        System.out.println("Alert message: " + alertText);
        Assert.assertTrue(alertText.contains(errStr));
        // Close alert (ОК)
        alert.accept();
    }
}
