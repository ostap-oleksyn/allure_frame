package pageobjects;


import locators.Google;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;

public class ResultPage extends BasePage {
    public ResultPage(WebDriver driver) {
        super(driver);
    }



    @Step("Click images tab")
    public void clickImageTab(){
       action(Google.IMAGES_TAB).click();
    }
}
