package pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
/**
 * class ProductStorePage
 * reflects the home page with main menu inside
 *
 */

public class ProductStorePage extends BasePage {
    @FindBy(id = "nameofuser")
    WebElement name_of_user;
    @FindBy(xpath = "/html/body/nav/div[1]/ul/li[1]/a")
    WebElement home_tab;
    @FindBy(xpath = "/html/body/div[5]/div/div[2]/div/div[1]/div")
    WebElement first_product;

    public ProductStorePage(){
        PageFactory.initElements(driver, this);
    }

    public void userInProductStore(){
        wait.until(ExpectedConditions.visibilityOf(name_of_user));
        Assert.assertTrue(name_of_user.getText().contains("Welcome"));
    }

    public void clickHomeTab(){
        wait.until(ExpectedConditions.visibilityOf(home_tab));
        home_tab.click();
    }

    public void clickFirstProduct(){
        wait.until(ExpectedConditions.visibilityOf(first_product));
        first_product.click();
    }

}
