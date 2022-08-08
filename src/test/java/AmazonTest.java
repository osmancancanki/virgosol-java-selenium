import org.junit.jupiter.api.Test;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductPage;

public class AmazonTest extends BaseTest{
    HomePage homePage;
    LoginPage loginPage;
    ProductPage productPage;
    AccountPage accountPage;

    @Test
    public void amazonTest() {
        homePage = new HomePage(driver);
        homePage.visitHomePage();
        //homePage.navigateToLogIn();
        //loginPage.login();
        //homePage.checkForLogin();
        homePage.chooseCategory("Bilgisayarlar");
        homePage.searchForProduct("msi");
        homePage.selectPageFromPagination("2");
        homePage.selectProductFromSearchList("1");
        productPage.addProductToList();
        homePage.navigateToList();
        accountPage.removeProductFromFavoriteList();
        //homePage.logout();
        //loginPage.checkForLogout();

    }
}
