package runner;


import action.Action;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
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
        waitUntil = new WaitUtil(driver);
        driver.manage().window().maximize();
    }

    protected Action action(){
        return new Action(driver);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}


