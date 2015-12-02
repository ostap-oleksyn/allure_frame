package pageobjects.rozetka;


import actions.ElementAction;
import actions.PageAction;
import org.openqa.selenium.WebDriver;
import ui.ILocator;
import utils.WaitImpl;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected ElementAction Action(ILocator locator) {
        return new ElementAction(driver, locator);
    }

    protected ElementAction Action(ILocator overLocator, ILocator clickLocator) {
        return new ElementAction(driver, overLocator, clickLocator);
    }

    protected PageAction Page() {
        return new PageAction(driver);
    }

    protected WaitImpl WaitUntil(ILocator locator) {
        return new WaitImpl(driver, locator);
    }

}

