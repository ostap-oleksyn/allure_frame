package runner;


import action.Action;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.WaitUtil;

import java.util.concurrent.TimeUnit;

public class TestRunner{

    protected WebDriver driver;
    protected Action action;
    protected WaitUtil waitUntil;
    private static final String URL = "https://www.google.com.ua";

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeClass
    public void setUp() {
        driver = new FirefoxDriver();
        action = new Action(driver);
        waitUntil = new WaitUtil(driver);
        driver.manage().window().maximize();
       //TODO - Remove implicit waits!!!
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        action.navigate(URL);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}


