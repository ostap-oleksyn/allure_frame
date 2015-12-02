package pageobjects.google;


import actions.ElementAction;
import org.openqa.selenium.WebDriver;
import ui.ILocator;

public class BasePage {

    protected WebDriver driver;


    public BasePage(WebDriver driver) {
        this.driver = driver;
    }


    protected ElementAction action(ILocator locator){
        return new ElementAction(driver, locator);
    }

}
