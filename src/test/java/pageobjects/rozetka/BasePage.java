package pageobjects.rozetka;


import actions.ElementAction;
import actions.PageAction;
import actions.WaitImpl;
import org.openqa.selenium.WebDriver;
import ui.ILocator;
import utils.TestUtil;

public class BasePage<T extends ILocator> {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected ElementAction element(final ILocator locator) {
        return new ElementAction(driver, locator);
    }

    protected PageAction page() {
        return new PageAction(driver);
    }

    protected WaitImpl waitUntil(final ILocator locator) {
        return new WaitImpl(driver, locator);
    }

    protected WaitImpl waitUntil() {
        return new WaitImpl(driver);
    }

    protected TestUtil test() {
        return new TestUtil(driver);
    }

    public ElementAction get(T element) {
        return new ElementAction(driver, element);
    }

}

