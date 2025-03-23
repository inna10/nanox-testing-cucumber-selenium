package pages;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * class ProductPage
 * reflects product details pane with Add to Cart button
 */

public class ProductPage extends BasePage {
    @FindBy(xpath = "/html/body/div[5]/div/div[2]/div/div[1]/div")
    WebElement product_detail;
    @FindBy(xpath = "*[@id='tbodyid']/div[2]/div/a")
    WebElement add_to_cart_product;
    @FindBy(xpath = "/html/body/div[5]/div/div[2]/div[2]/div/a")
    WebElement add_to_cart;

    public ProductPage() {
        PageFactory.initElements(driver, this);
    }

    public void AddToCardButtonIsEnabled() {
        wait.until(ExpectedConditions.visibilityOf(product_detail));
        driver.findElement(By.className("btn btn-success btn-lg")).isEnabled();
    }

    public void clickAddToCartProduct() {
        wait.until(ExpectedConditions.visibilityOf(add_to_cart));
        add_to_cart.click();
    }

    public void assertingProductAddedMessage() {
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();

        // Error message
        String alertText = alert.getText();
        System.out.println("Product added message: " + alertText);
        Assert.assertTrue(alertText.contains("Product added") || alertText.contains("Wrong password."));
        // Close alert (ОК)
        alert.accept();
    }
}
