package runner;


import actions.ElementAction;
import actions.PageAction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import ui.ILocator;
import utils.WaitUtil;


public class TestRunner {

    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    protected ElementAction Action(final ILocator locator) {
        return new ElementAction(driver, locator);
    }

    protected ElementAction Action(final ILocator overLocator, final ILocator clickLocator) {
        return new ElementAction(driver, overLocator, clickLocator);
    }

    protected PageAction Page() {
        return new PageAction(driver);
    }

    protected WaitUtil WaitUntil(final ILocator locator) {
        return new WaitUtil(driver, locator);
    }

    protected WaitUtil WaitUntil() {
        return new WaitUtil(driver);
    }

    @BeforeClass
    public void setUp() {
        //TODO - implement grid support
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}


