package tests;

import org.junit.jupiter.api.Test;
import pages.HomePage;

public class AmazonTest {
    HomePage homePage = new HomePage();

    @Test
    public void amazonTest() {
        homePage.visitHomePage();
        homePage.navigateToLogIn();
        homePage.chooseCategory("Bilgisayarlar");
        homePage.searchForProduct("msi");
    }

}
