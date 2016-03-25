package runner;


import actions.ElementAction;
import actions.PageAction;
import actions.VerifyImpl;
import actions.WaitImpl;
import enums.Browsers;
import listeners.TestResultListener;
import listeners.VerifyListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import ui.ILocator;
import utils.DriverBuilder;
import utils.TestResult;
import utils.TestUtil;

import java.util.Locale;

@Listeners({TestResultListener.class, VerifyListener.class})
public class TestRunner {

    private TestResult result;

    private WebDriver driver;

    protected WebDriver getWebDriver() {
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


    @Parameters({"browser"})
    @BeforeClass
    public void setUp(@Optional("firefox")final String browserParam) {
        //TODO - implement grid support

        final DriverBuilder driverBuilder = new DriverBuilder();
        result = new TestResult();

        final Browsers browser = Browsers.valueOf(browserParam.toUpperCase(Locale.ENGLISH));
        driverBuilder.buildDriver(browser);

        driver = driverBuilder.getDriver();
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}


