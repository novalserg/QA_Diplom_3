import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;
//Для тестов в Яндекс Браузере
//import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.AuthorizationPage;
import pages.RegistrationPage;
import pojo.UserData;
import utils.DetailsUser;

import static com.codeborne.selenide.Selenide.*;
//Для тестов в Яндекс Браузере
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

public class RegistrationTest {

    private final String name = RandomStringUtils.randomAlphabetic(6);
    private final String email = RandomStringUtils.randomAlphabetic(6) + "@mail.ru";
    private final String password = RandomStringUtils.randomAlphabetic(7);
    public String accessToken;

    DetailsUser detailsUser;
    UserData userAuthorization = new UserData(email, password);

    @Before
    public void setUp() {
        detailsUser = new DetailsUser();
//         Для тестов в Яндекс Браузере
//         System.setProperty("webdriver.chrome.driver", "src/main/resources/yandexdriver.exe");
//         ChromeDriver driver = new ChromeDriver();
//         setWebDriver(driver);
    }

    @Test
    @DisplayName("Успешная регистрация")
    @Description("Пользователя можно зарегистрировать")
    public void userRegistration() {

        HomePage homePage = open(HomePage.URL, HomePage.class);
        homePage.clickSignInButton();
        AuthorizationPage authorizationPage = page(AuthorizationPage.class);
        authorizationPage.clickRegisterButton();
        RegistrationPage registrationPage = page(RegistrationPage.class);
        registrationPage.setValueInputName(name);
        registrationPage.setValueInputEmail(email);
        registrationPage.setValueInputPassword(password);
        registrationPage.clickRegisterButton();
        authorizationPage.assertInscriptionEntranceVisible();
        ValidatableResponse response = detailsUser.login(userAuthorization);
        accessToken = response.extract().path("accessToken");
        detailsUser.removal(accessToken);
    }

    @Test
    @DisplayName("Ошибка для некорректного пароля")
    @Description("Возникает ошибка для пароля меньше 6 символов")
    public void passwordError() {

        HomePage homePage = open(HomePage.URL, HomePage.class);
        homePage.clickSignInButton();
        AuthorizationPage authorizationPage = page(AuthorizationPage.class);
        authorizationPage.clickRegisterButton();
        RegistrationPage registrationPage = page(RegistrationPage.class);
        registrationPage.setValueInputName(name);
        registrationPage.setValueInputEmail(email);
        registrationPage.setValueInputPassword("lol17");
        registrationPage.clickRegisterButton();
        registrationPage.assertMessageWrongPassword();
    }
}