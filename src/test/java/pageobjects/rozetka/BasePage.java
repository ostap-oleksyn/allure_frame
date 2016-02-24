package pageobjects.rozetka;


import actions.Action;
import actions.ElementAction;
import actions.PageAction;
import org.openqa.selenium.WebDriver;
import ui.ILocator;
import utils.TestUtil;
import actions.WaitImpl;

public class BasePage {

    protected WebDriver driver;
    protected Action action;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.action = new Action(this.driver);
    }

    protected ElementAction Element(final ILocator locator) {
        return new ElementAction(driver, locator);
    }

    protected ElementAction Element(final ILocator overLocator, final ILocator clickLocator) {
        return new ElementAction(driver, overLocator, clickLocator);
    }

    protected PageAction Page() {
        return new PageAction(driver);
    }

    protected WaitImpl WaitUntil(final ILocator locator) {
        return new WaitImpl(driver, locator);
    }

    protected WaitImpl WaitUntil() {
        return new WaitImpl(driver);
    }

    protected TestUtil Test(){
        return new TestUtil(driver);
    }

}

