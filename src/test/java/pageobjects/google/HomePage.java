package pageobjects.google;


import locators.Google;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Step("Search for {0}")
    public ResultPage doSearchFor(String term) {
        action(Google.SEARCH_FIELD).type(term);
        action(Google.SEARCH_BUTTON).click();
        return new ResultPage(driver);
    }

}
