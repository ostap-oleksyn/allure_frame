package pageobjects.rozetka;


import locators.Rozetka;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;

public class HomePage extends BasePage {


    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Step("Login")
    public HomePage login(){
        element(Rozetka.PERSONAL_LINK).click();
        element(Rozetka.LOGIN_FIELD).type("gobland@mail.ru");
        element(Rozetka.PASSWORD_FIELD).type("test1234");
        element(Rozetka.LOGIN_BUTTON).click();
        return this;
    }

    @Step("Search for {0}")
    public ResultPage doSearchFor(final String text){
        element(Rozetka.SEARCH_FIELD).type(text);
        element(Rozetka.SEARCH_FIELD).submit();
        return new ResultPage(driver);
    }
}
