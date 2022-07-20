import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pages.HomePage;

import static com.codeborne.selenide.Selenide.open;

public class GoToSectionTest {

    @Test
    @DisplayName("Переход к разделу «Булки»")
    @Description("Пользователь может перейти к разделу «Булки»")
    public void goToTheBunsSection() {

        HomePage homePage = open(HomePage.URL, HomePage.class);
        homePage.scrollBlockIngredientsToBottom();
      homePage.clickSaucesButton();
        homePage.clickBunsButton();
        homePage.assertBunsChaptersVisible();
    }

    @Test
    @DisplayName("Переход к разделу «Соусы»")
    @Description("Пользователь может перейти к разделу «Соусы»")
    public void goToTheSaucesSection() {


        HomePage homePage = open(HomePage.URL, HomePage.class);
        homePage.scrollBlockIngredientsToBottom();
        homePage.clickSaucesButton();
        homePage.assertSaucesChaptersVisible();
    }

    @Test
    @DisplayName("Переход к разделу «Начинки»")
    @Description("Пользователь может перейти к разделу «Начинки»")
    public void goToTheToppingsSection() {

        HomePage homePage = open(HomePage.URL, HomePage.class);
        homePage.clickBunsButton();
        homePage.clickToppingsButton();
        homePage.toppingsButtonSelected();

    }
}