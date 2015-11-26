package pageobjects.rozetka;


import action.Action;
import action.PageAction;
import org.openqa.selenium.WebDriver;
import ui.ILocator;
import utils.WaitUtil;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected Action Action(ILocator locator) {
        return new Action(driver, locator);
    }

    protected Action Action(ILocator overLocator, ILocator clickLocator) {
        return new Action(driver, overLocator, clickLocator);
    }

    protected PageAction Page() {
        return new PageAction(driver);
    }

    protected WaitUtil WaitUntil(ILocator locator) {
        return new WaitUtil(driver, locator);
    }

}

