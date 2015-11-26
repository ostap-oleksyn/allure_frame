package pageobjects.google;


import action.Action;
import org.openqa.selenium.WebDriver;
import ui.ILocator;

public class BasePage {

    protected WebDriver driver;


    public BasePage(WebDriver driver) {
        this.driver = driver;
    }


    protected Action action(ILocator locator){
        return new Action(driver, locator);
    }

}
