package runner;


import action.Action;
import action.PageAction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import ui.ILocator;
import utils.WaitUtil;

public class TestRunner {

    private WebDriver driver;
    protected WaitUtil waitUntil;
    public WebDriver getDriver() {
        return driver;
    }

    @BeforeClass
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }



    protected Action Action(ILocator locator){
        return new Action(driver, locator);
    }

    protected Action Action(ILocator overLocator, ILocator clickLocator){
        return new Action(driver, overLocator, clickLocator);
    }

    protected PageAction Page(){
        return new PageAction(driver);
    }

    protected WaitUtil WaitUntil(ILocator locator){
        return new WaitUtil(driver, locator);
    }


    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}


