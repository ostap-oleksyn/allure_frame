package pageobjects;


import locators.Google;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;

public class ResultPage extends BasePage {
    public ResultPage(WebDriver driver) {
        super(driver);
    }

   
    public void clickSearchButton(){
       action.get(Google.SEARCH_BUTTON).click();
    }


    public void clickImageTab(){
       action.get(Google.IMAGES_TAB).click();
    }
}
