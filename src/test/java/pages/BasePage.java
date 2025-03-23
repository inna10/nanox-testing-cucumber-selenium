package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public BasePage()
    {
        System.out.println("Base Page Constructor!!!!!!!!!!!!!!!!!!!!!!!");
    }
    public static WebDriver getDriver(){
        return driver;
    }
    public static WebDriverWait getWebDriverWait(){
        return wait;
    }

    public static WebDriver initDriver(){
        System.out.println("!!!!!!!!!!!!!!!!!INIT Driver!!!!!!!!!!!!!!!!!!!!!!!");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        return driver;
    }
}
