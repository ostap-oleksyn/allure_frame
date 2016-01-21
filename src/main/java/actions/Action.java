package actions;


import org.openqa.selenium.WebDriver;
import ui.ILocator;
import utils.TestImpl;

public final class Action {

    private WebDriver driver;

    public Action(WebDriver driver) {
        this.driver = driver;
    }

    public ElementAction Element(final ILocator locator) {
        return new ElementAction(driver, locator);
    }

    public ElementAction Element(final ILocator overLocator, final ILocator clickLocator) {
        return new ElementAction(driver, overLocator, clickLocator);
    }

    public PageAction Page() {
        return new PageAction(driver);
    }

    public WaitImpl WaitUntil(final ILocator locator) {
        return new WaitImpl(driver, locator);
    }

    public TestImpl Test() {
        return new TestImpl(driver);
    }
}
