package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage extends BasePage {
    ProductPage productPage;

    public AccountPage(WebDriver driver) {
        super(driver);
        productPage = new ProductPage(driver);
    }

    public ProductPage productPage() {
        return this.productPage;
    }

    public void removeProductFromFavoriteList() {
        driver.findElement(By.xpath("//li[@data-id='" + productPage.productId + "']//input[@name='submit.deleteItem']")).click();
        driver.findElement(By.xpath("//li[@data-id='" + productPage.productId + "']//*[text()='Silindi']")).isDisplayed();
    }
}
