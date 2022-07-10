import pages.LoginPage;
import com.codeborne.selenide.Configuration;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;

public class RegistrationChromeTest {

    @Before
    public void fullScreenBrowser(){
        Configuration.browserSize = "1920x1080";

    }

    @Test
    public void registrationPositiveTest(){
        LoginPage loginPage = open("https://stellarburgers.nomoreparties.site/login", LoginPage.class);
        loginPage.loginSubmitButtonClick();

            }

}
