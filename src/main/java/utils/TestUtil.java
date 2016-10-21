package utils;


import actions.PageActionImpl;
import exceptions.TestFailedException;
import org.openqa.selenium.WebDriver;
import org.testng.SkipException;
import ru.yandex.qatools.allure.annotations.Step;

public class TestUtil {

    private WebDriver driver;
    private boolean takeScreenshot;

    public TestUtil(WebDriver driver) {
        this.driver = driver;
    }

    public TestUtil withScreenshot() {
        this.takeScreenshot = true;
        return this;
    }

    public void skip(String message) {
        logSkip(message);
    }

    public void fail(String message) {
        throw new TestFailedException(message);
    }

    public void sleep(int seconds) {
        Log.info("TEST: Sleep for " + seconds + " second");
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException var3) {
            Thread.currentThread().interrupt();
        }
    }

    @Step("TEST SKIPPED: {0}")
    private void logSkip(String message) {
        if (takeScreenshot) {
            new PageActionImpl(driver).takeScreenshot();
        }
        throw new SkipException(message);
    }
}
