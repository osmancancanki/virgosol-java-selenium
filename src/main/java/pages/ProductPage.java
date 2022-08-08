package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage {
    By idInput = By.xpath("//*[@name='sourceCustomerOrgListID']");
    By addToListButton = By.xpath("//*[@title='Listeye Ekle']");
    By listLink = By.id("huc-list-link");
    By modalCloseButton = By.xpath("//*[@class='a-button-close a-button-close-a11y a-declarative']");

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public static String productId;

    public void addProductToList() {
        productId = getAttributeFromElement(idInput, "value");
        clickToElement(addToListButton);
        elementIsDisplayed(listLink);
        clickToElement(modalCloseButton);
    }
}
