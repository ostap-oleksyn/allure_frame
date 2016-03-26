package actions;


import org.openqa.selenium.WebDriver;
import ui.ILocator;
import utils.TestUtil;

public final class Action {

    private WebDriver driver;

    public Action(final WebDriver driver) {
        this.driver = driver;
    }

    public ElementAction element(final ILocator locator) {
        return new ElementAction(driver, locator);
    }

    public ElementAction element(final ILocator overLocator, final ILocator clickLocator) {
        return new ElementAction(driver, overLocator, clickLocator);
    }

    public PageAction page() {
        return new PageAction(driver);
    }

    public WaitImpl waitUntil(final ILocator locator) {
        return new WaitImpl(driver, locator);
    }

    public TestUtil test() {
        return new TestUtil(driver);
    }
}
