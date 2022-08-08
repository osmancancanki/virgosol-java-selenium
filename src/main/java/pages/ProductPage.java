package pages;

import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage {
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public static String productId;

    public void addProductToList() {
        productId = getAttributeFromElement("product_id_input", "value");
        clickToElement("product_add_list_button");
        elementIsDisplayed("product_list_link");
        clickToElement("product_modal_close_button");
    }
}
