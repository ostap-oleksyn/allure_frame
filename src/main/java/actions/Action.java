package actions;


import org.openqa.selenium.WebDriver;
import ui.ILocator;
import utils.TestUtil;

public class Action {

    private WebDriver driver;

    public Action(WebDriver driver) {
        this.driver = driver;
    }

    public ElementAction element(ILocator locator) {
        return new ElementAction(driver, locator);
    }

    public PageAction page() {
        return new PageAction(driver);
    }

    public WaitImpl waitUntil(ILocator locator) {
        return new WaitImpl(driver, locator);
    }

    public TestUtil test() {
        return new TestUtil(driver);
    }
}
