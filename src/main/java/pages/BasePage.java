package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Log;

import java.util.ArrayList;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BasePage {
    WebDriver driver;
    WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    Log log = new Log();

    public WebElement findElement(By locatorName) {
        wait = new WebDriverWait(driver, 10);
        WebElement webElement = wait.until(ExpectedConditions.presenceOfElementLocated(locatorName));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center', inline: 'center'})", webElement);
        return webElement;
    }

    public void navigateToUrl(String url) {
        driver.get(url);
    }

    public void checkForUrl(String url) {
        assertThat(driver.getCurrentUrl()).isEqualTo(url);

    }

    public void clickToElement(By locatorName) {
        try {
            findElement(locatorName).click();
        } catch (Exception e) {
            log.info("Click action does not work!" + e);
        }
    }

    public void hoverElement(By locatorName) {
        Actions action = new Actions(driver);
        try {
            action.moveToElement(findElement(locatorName)).perform();
        } catch (Exception e) {
            log.info("Click action does not work!" + e);
        }
    }

    public void getDropdownItem(By locatorName, String itemName) {
        try {
            Select dropdownItems = new Select(findElement(locatorName));
            dropdownItems.selectByVisibleText(itemName);
        } catch (Exception e) {
            log.info(itemName + "Item is not found or selected!" + e);
        }
    }

    public String getTextFromElement(By locatorName) {
        return findElement(locatorName).getText();
    }

    public String getAttributeFromElement(By locatorName, String attributeName) {
        return findElement(locatorName).getAttribute(attributeName);
    }

    public void sendKeysToElement(By locatorName, String text) {
        try {
            findElement(locatorName).sendKeys(text);
        } catch (Exception e) {
            log.info("Send keys action does not work!" + e);
        }
    }

    public Boolean elementIsDisplayed(By locatorName) {
        return findElement(locatorName).isDisplayed();
    }

    public void nextTab() {
        ArrayList<String> tabs2 = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
    }
}
