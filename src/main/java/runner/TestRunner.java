package runner;


import actions.ElementAction;
import actions.PageAction;
import actions.VerifyImpl;
import actions.WaitImpl;
import enums.Browsers;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import ui.ILocator;
import utils.DriverBuilder;
import utils.TestResult;
import utils.TestUtil;

import java.util.Locale;

public class TestRunner {

    private TestResult result;

    private WebDriver driver;

    protected WebDriver getWebDriver() {
        return driver;
    }

    protected ElementAction element(ILocator locator) {
        return new ElementAction(driver, locator);
    }

    protected PageAction page() {
        return new PageAction(driver);
    }

    protected WaitImpl waitUntil(ILocator locator) {
        return new WaitImpl(driver, locator);
    }

    protected TestUtil test() {
        return new TestUtil(driver);
    }

    protected VerifyImpl verify(boolean condition) {
        return new VerifyImpl(condition, driver, result);
    }


    @Parameters({"browser"})
    @BeforeClass
    protected void setUp(@Optional("firefox") String browserParam) {
        //TODO - implement grid support

        DriverBuilder driverBuilder = new DriverBuilder();
        result = new TestResult();

        Browsers browser = Browsers.valueOf(browserParam.toUpperCase(Locale.ENGLISH));
        driverBuilder.buildDriver(browser);

        driver = driverBuilder.getDriver();
        driver.manage().window().maximize();
    }

    @AfterClass
    protected void tearDown() {
        driver.quit();
    }
}


