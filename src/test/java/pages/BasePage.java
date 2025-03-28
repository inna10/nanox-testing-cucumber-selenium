package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * Base Page class
 * Provides driver initialization (as a singletone object)
 */
public class BasePage {
    static Logger logger = Logger.getLogger(BasePage.class.getName());
    public static WebDriver driver;
    public static WebDriverWait wait;

    public BasePage() {
        logger.info("BasePage Constructor called for " + this.getClass().getSimpleName());
    }

    public static WebDriver getDriver() {
        return driver;
    }

    /**
     * @return WebDriverWait object provides waiting-until-appearance objects into HTML DOM
     */
    public static WebDriverWait getWebDriverWait() {
        return wait;
    }

    public static WebDriver initDriver() {
        logger.info("Driver initializing...");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        return driver;
    }

    static {
        Properties properties = System.getProperties();
        try {//load resources from the classpath instead of a specific file location. This will work regardless of how the code is packaged
            InputStream inputStream = BasePage.class.getResourceAsStream("/test.properties");
            properties.load(inputStream);
            //new FileInputStream(new File("resources/test.properties")));
        } catch (Exception ex) {
            ex.printStackTrace();
            System.exit(-1);
        }
    }
}
