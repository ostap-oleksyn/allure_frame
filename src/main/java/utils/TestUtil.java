package utils;


import actions.PageActionImpl;
import exceptions.TestFailedException;
import org.openqa.selenium.WebDriver;
import org.testng.SkipException;
import ru.yandex.qatools.allure.annotations.Step;

public final class TestUtil {

    private final WebDriver driver;
    private boolean takeScreenshot;

    public TestUtil(final WebDriver driver) {
        this.driver = driver;
    }

    public TestUtil withScreenshot() {
        this.takeScreenshot = true;
        return this;
    }

    public void skip(final String message) {
        logSkip(message);
    }

    public void fail(final String message) {
        throw new TestFailedException(message);
    }

    public void sleep(final int seconds) {
        LogUtil.log("TEST: Sleep for " + seconds + " second");
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException var3) {
            Thread.currentThread().interrupt();
        }
    }

    @Step("TEST SKIPPED: {0}")
    private void logSkip(final String message) {
        if (takeScreenshot) {
            new PageActionImpl(driver).takeScreenshot();
        }
        throw new SkipException(message);
    }
}
