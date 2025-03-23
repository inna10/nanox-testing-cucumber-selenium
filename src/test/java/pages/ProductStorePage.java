package pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductStorePage extends BasePage {
    @FindBy(id = "nameofuser")
    WebElement name_of_user;

    public ProductStorePage(){
        PageFactory.initElements(driver, this);
    }

    public void userInProductStore(){
        wait.until(ExpectedConditions.visibilityOf(name_of_user));
        Assert.assertTrue(name_of_user.getText().contains("Welcome"));
    }

}
