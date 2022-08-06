package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.ConfigReader;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    public static WebDriver driver;
    protected ConfigReader configReader = new ConfigReader("config");
    private static Logger logger = LoggerFactory.getLogger(BaseTest.class);

    public void initializeDriver() {

        if (configReader.getProperty("web_driver").equals("chrome")) {
            WebDriverManager.chromedriver().setup();

            ChromeOptions options = new ChromeOptions();

            driver = new ChromeDriver(options);
            options.addArguments("incognito");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } else if (configReader.getProperty("web_driver").equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (configReader.getProperty("web_driver").equals("ie")) {
            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();
        }
    }

    public void closeDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

    public void testFailed() {
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshotFile, new File("target/" + System.currentTimeMillis() + ".png"));
        } catch (Exception e) {
            logger.warn("Test failed!", e);
        }
    }
}
