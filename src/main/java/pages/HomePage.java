//главная страница
package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.visible;

public class HomePage {

    public static final String URL = "https://stellarburgers.nomoreparties.site/";

    //локатор кнопки "Личный кабинет"
    @FindBy(how = How.XPATH,using = "//*[@id=\"root\"]/div/header/nav/a")
    public SelenideElement personalAccountButton;

    //локатор кнопки "Войти в аккаунт"
    @FindBy(how = How.XPATH,using = ".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg']")
    public SelenideElement signInButton;

    //локатор кнопок "Булки"
    @FindBy(how = How.XPATH,using = "//*[@id=\"root\"]/div/main/section[1]/div[1]/div[1]")
    public SelenideElement bunsButton;

    //локатор кнопки "Соусы"
    @FindBy(how = How.XPATH,using = "//*[@id=\"root\"]/div/main/section[1]/div[1]/div[2]")
    public SelenideElement saucesButton;

    //локатор кнопки "Начинки"
    @FindBy(how = How.XPATH,using = "//*[@id=\"root\"]/div/main/section[1]/div[1]/div[3]")
    public SelenideElement toppingsButton;

    //локатор раздела "Булки"
    @FindBy(how = How.XPATH, using = "/html/body/div/div/main/section[1]/div[2]/h2[1]")
    public SelenideElement bunsChapter;

    //локатор раздела "Соусы"
    @FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/section[1]/div[2]/h2[2]")
    public SelenideElement saucesChapter;

    //локатор раздела "Начинки"
    @FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/section[1]/div[2]/h2[3]")
    public SelenideElement toppingsChapter;

    //локатор кнопки "Оформить заказ"
    @FindBy(how = How.XPATH,using = ".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg']")
    public SelenideElement checkoutButton;

    @FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/section[1]/div[2]/ul[3]/a[9]")
    public SelenideElement toppingFilleItem;

    @FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/section[1]/div[2]")
    public SelenideElement blockIngredients;


    //метод клика по кнопке "Войти в аккаунт"
    public void clickSignInButton() {
        signInButton.click();
    }

    //метод клика по кнопке "Личный кабинет"
    public void clickPersonalAccountButton() {
        personalAccountButton.click();
    }

    //метод получения локатора кнопки "Оформить заказ"
    public void assertCheckoutButtonVisible() {
        checkoutButton.shouldBe(visible);
    }

    //метод клика по кнопке "Соусы"
    public void clickSaucesButton() {
        saucesButton.click();
    }

    //метод клика по кнопке "Начинки"
    public void clickToppingsButton() {
        toppingsButton.click();
    }

    //метод клика по кнопке "Булки"
    public void clickBunsButton() {
        bunsButton.click();
    }

    //метод получения локатора раздела "Соусы"
    public void assertSaucesChaptersVisible() {
        saucesChapter.shouldBe(visible);
    }

    //метод получения локатора раздела "Начинки"
    public void assertToppingsChaptersVisible() {
        toppingsChapter.shouldBe(visible);
    }

    //метод получения локатора раздела "Булки"
    public void assertBunsChaptersVisible() {
        bunsChapter.shouldBe(visible);
    }

    public void assertToppingFilleItemVisible(){
        toppingFilleItem.shouldBe(visible);
    }

    public void scrollBlockIngredientsToBottom(){
        toppingFilleItem.scrollIntoView(true);
    }
}