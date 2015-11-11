package pageobjects;


import locators.Google;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }


    public ResultPage doSearchFor(String term) {
        action.get(Google.SEARCH_FIELD).type(term);
        return new ResultPage(driver);
    }

}
