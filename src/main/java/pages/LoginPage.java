package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

    @FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/form/fieldset[1]/div/div/input")
    private SelenideElement inputEmailField;

    @FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/form/fieldset[2]/div/div/input")
    private SelenideElement inputPasswordField;

    @FindBy (how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/form/button")
    private SelenideElement loginSubmitButton;

    @FindBy (how = How.XPATH, using = "Зарегистрироваться")
    private SelenideElement registrationButton;

    public void userDataFill(String name, String password){
        inputEmailField.setValue(name);
        inputPasswordField.setValue(password);
    }

    public void loginSubmitButtonClick(){
        loginSubmitButton.click();
    }

}
