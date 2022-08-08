package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class HomePage extends BasePage {

    ConfigReader configReader;

    By searchInput=By.id("twotabsearchtextbox");
    By searchButton=By.id("nav-search-submit-button");
    By cookieButton=By.xpath("//*[@id='a-autoid-0-announce']");
    By categoryDropdown=By.id("nav-search-dropdown-card");
    By categoryDropdownItem=By.xpath("//*[@id='searchDropdownBox']");
    By categoryDropdownLabel=By.id(":nav-search-label-id");
    By loginNavigation=By.xpath("//*[text()='Hesap ve Listeler']");
    By userNameText=By.id("nav-link-accountList-nav-line-1");
    By logoutNavigation=By.xpath("//*[text()='Çıkış Yap']");
    By accountNavigation=By.xpath("//*[@data-csa-c-content-id='nav_youraccount_btn']");
    By listNavigation=By.xpath("//*[@class='nav-text'][text()='Favori Listem']");
    By searchListTitle=By.xpath("//*[@class='a-color-state a-text-bold']");
    By searchSelectedPage=By.xpath("//*[@class='s-pagination-item s-pagination-selected']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void visitHomePage() {
        configReader = new ConfigReader("config");
        navigateToUrl(configReader.getProperty("base_url"));
        checkForUrl(configReader.getProperty("base_url"));
        clickToElement(cookieButton);
    }

    public void navigateToLogIn() {
        clickToElement(loginNavigation);
    }

    public void navigateToList() {
        hoverElement(accountNavigation);
        clickToElement(listNavigation);
    }

    public void chooseCategory(String categoryName) {
        clickToElement(categoryDropdown);
        getDropdownItem(categoryDropdownItem, categoryName);
        assertThat(getTextFromElement(categoryDropdownLabel)).isEqualTo(categoryName);
    }

    public void searchForProduct(String productName) {
        clickToElement(searchInput);
        sendKeysToElement(searchInput, productName);
        clickToElement(searchButton);
        assertThat(getTextFromElement(searchListTitle)).isEqualTo(productName);
    }

    public void selectPageFromPagination(String pageNumber) {
        driver.findElement(By.xpath("//*[@aria-label='" + pageNumber + " sayfasına git']")).click();
        assertThat(getTextFromElement(searchSelectedPage)).isEqualTo(pageNumber);
    }

    public void selectProductFromSearchList(String index) {
        driver.findElement(By.xpath("//*[@data-index='" + index + "']")).click();
    }

    public void logout() {
        hoverElement(accountNavigation);
        clickToElement(logoutNavigation);
    }

    public void checkForLogin() {
        elementIsDisplayed(userNameText);
    }
}
