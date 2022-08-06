package pages;

import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tests.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConfigReader;

import java.util.ArrayList;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BasePage extends BaseTest {
    private static Logger logger = LoggerFactory.getLogger(BasePage.class);
    ConfigReader elementReader = new ConfigReader("element");

    public WebElement findElement(String locatorName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        By locator = elementReader.getElementValue(locatorName);
        WebElement webElement = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center', inline: 'center'})", webElement);
        return webElement;
    }

    public void navigateToUrl(String url) {
        driver.get(configReader.getProperty(url));
    }

    public void clickToElement(String locatorName) {
        try {
            findElement(locatorName).click();
        } catch (Exception e) {
            logger.warn("Click action does not work!", e);
        }
    }

    public void getDropdownItem(String locatorName, String itemName) {
        try {
            Select dropdownItems = new Select(findElement(locatorName));
            dropdownItems.selectByVisibleText(itemName);
        } catch (Exception e) {
            logger.warn(itemName + "Item is not found or selected!", e);
        }
    }

    public void compareTextWithExpected(String locatorName, String expectedText) {
        String text = findElement(locatorName).getText();
        assertThat(expectedText).isEqualTo(text);
    }

    public String getTextFromElement(String locatorName) {
        return findElement(locatorName).getText();
    }

    public void sendKeysToElement(String locatorName, String text) {
        try {
            findElement(locatorName).sendKeys(text);
        } catch (Exception e) {
            logger.warn("Send keys action does not work!", e);
        }
    }

    public void elementIsDisplayed(String locatorName) {
        findElement(locatorName).isDisplayed();
    }

    public void nextTab() {
        ArrayList<String> tabs2 = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
    }
}
