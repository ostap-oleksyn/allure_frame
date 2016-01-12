package pageobjects.rozetka;


import locators.Rozetka;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;

public class HomePage extends BasePage {


    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Step("Login")
    public HomePage login(){
        Element(Rozetka.PERSONAL_LINK).click();
        Element(Rozetka.LOGIN_FIELD).type("gobland@mail.ru");
        Element(Rozetka.PASSWORD_FIELD).type("test1234");
        Element(Rozetka.LOGIN_BUTTON).click();
        return this;
    }

    @Step("Search for {0}")
    public ResultPage doSearchFor(final String term){
        Element(Rozetka.SEARCH_FIELD).type(term);
        Element(Rozetka.SEARCH_FIELD).submit();
        return new ResultPage(driver);
    }
}
