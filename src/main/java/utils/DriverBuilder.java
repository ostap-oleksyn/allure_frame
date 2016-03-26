package utils;


import enums.Browsers;
import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public final class DriverBuilder {

    private WebDriver driver;
    private static final String DRIVER_PATH = "src\\main\\resources\\";

    public void buildDriver(final Browsers browser){
        switch (browser){
            case CHROME:
                if (SystemUtils.IS_OS_WINDOWS) {
                    System.setProperty("webdriver.chrome.driver", DRIVER_PATH + "chromedriver.exe");
                } else if (SystemUtils.IS_OS_LINUX) {
                    System.setProperty("webdriver.chrome.driver", DRIVER_PATH.replace("\\","/" + "chromedriver"));
                }
                driver = new ChromeDriver();
                break;
            case FIREFOX:
                driver = new FirefoxDriver();
                break;
            case IE:
                if (SystemUtils.IS_OS_WINDOWS) {
                    System.setProperty("webdriver.ie.driver", DRIVER_PATH + "IEDriverServer.exe");
                } else if (SystemUtils.IS_OS_LINUX) {
                    throw new IllegalStateException("Linux doesn't support Internet Explorer");
                }
                driver = new InternetExplorerDriver();
                break;
            default:
                driver = new FirefoxDriver();
                break;
        }
    }

    public WebDriver getDriver(){
        return driver;
    }

}
