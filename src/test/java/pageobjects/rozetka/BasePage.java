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

    protected ElementAction Element(final ILocator locator) {
        return new ElementAction(driver, locator);
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

    protected TestUtil Test() {
        return new TestUtil(driver);
    }

    public ElementAction get(T element) {
        return new ElementAction(driver, element);
    }

}

