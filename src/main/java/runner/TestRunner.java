package runner;


import actions.ElementAction;
import actions.PageAction;
import actions.VerifyImpl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import ui.ILocator;
import utils.TestUtil;
import utils.TestResult;
import actions.WaitImpl;


public class TestRunner {
    private TestResult result;

    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
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

    protected TestUtil Test() {
        return new TestUtil(driver);
    }

    protected VerifyImpl Verify(final boolean condition) {
        return new VerifyImpl(condition, driver, result);
    }


    @BeforeClass
    public void setUp() {
        //TODO - implement grid support
        result = new TestResult();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}


