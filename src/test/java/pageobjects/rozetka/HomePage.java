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
        Action(Rozetka.PERSONAL_LINK).click();
        Action(Rozetka.LOGIN_FIELD).type("ostap.oleksyn@gmail.com");
        Action(Rozetka.PASSWORD_FIELD).type("omnius123");
        Action(Rozetka.LOGIN_BUTTON).click();
        return this;
    }

    @Step("Search for {0}")
    public ResultPage doSearchFor(final String term){
        Action(Rozetka.SEARCH_FIELD).type(term);
        Action(Rozetka.SEARCH_FIELD).sendKeys(Keys.ENTER);
        return new ResultPage(driver);
    }
}
