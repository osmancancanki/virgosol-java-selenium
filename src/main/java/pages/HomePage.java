package pages;

public class HomePage extends BasePage {
    public void visitHomePage() {
        navigateToUrl("base_url");
        //page is displayed
        clickToElement("home_cookie_button");
    }

    public void navigateToLogIn() {
        clickToElement("home_login_navigation");
        clickToElement("home_login_item");
    }

    public void navigateToFavorite() {
    }

    public void chooseCategory(String categoryName) {
        clickToElement("home_category_dropdown");
        getDropdownItem("home_category_dropdown_items", categoryName);
        getTextFromElement("home_category_dropdown_label");
        compareTextWithExpected("home_category_dropdown_label", categoryName);
    }

    public void searchForProduct(String productName) {
        clickToElement("home_search_input");
        sendKeysToElement("home_search_input", productName);
        clickToElement("home_search_button");
        compareTextWithExpected("home_search_list_title", productName);
    }

    public void checkForLogin() {
        elementIsDisplayed("home_logged_in_dropdown");
    }

    public void checkForLogout() {
        elementIsDisplayed("home_logged_out_dropdown");
    }
}
