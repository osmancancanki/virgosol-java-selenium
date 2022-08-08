package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class HomePage extends BasePage {

    ConfigReader configReader;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void visitHomePage() {
        configReader = new ConfigReader("config");
        navigateToUrl(configReader.getProperty("base_url"));
        checkForUrl(configReader.getProperty("base_url"));
        clickToElement("home_cookie_button");
    }

    public void navigateToLogIn() {
        clickToElement("home_login_navigation");
    }

    public void navigateToList() {
        hoverElement("home_account_navigation");
        clickToElement("home_list_navigation");
    }

    public void chooseCategory(String categoryName) {
        clickToElement("home_category_dropdown");
        getDropdownItem("home_category_dropdown_items", categoryName);
        getTextFromElement("home_category_dropdown_label");
        String name = findElement("home_category_dropdown_label").getText();
        assertThat(categoryName).isEqualTo(name);
    }

    public void searchForProduct(String productName) {
        clickToElement("home_search_input");
        sendKeysToElement("home_search_input", productName);
        clickToElement("home_search_button");
        String title = findElement("home_search_list_title").getText();
        assertThat(productName).isEqualTo(title);
    }

    public void selectProductFromSearchList(String index) {
        driver.findElement(By.xpath("//*[@data-index='" + index + "']")).click();
    }

    public void logout() {
        hoverElement("home_account_navigation");
        clickToElement("home_logout_navigation");
    }

    public void checkForLogin() {
        elementIsDisplayed("home_user_name_text");
    }
}
