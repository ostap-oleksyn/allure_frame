package utils;


import actions.PageActionImpl;
import exceptions.TestFailedException;
import org.openqa.selenium.WebDriver;
import org.testng.SkipException;
import ru.yandex.qatools.allure.annotations.Step;

public final class TestImpl {

    private final WebDriver driver;
    private boolean takeScreenshot;

    public TestImpl(final WebDriver driver) {
        this.driver = driver;
    }

    public TestImpl withScreenshot() {
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
        TimerImpl.sleep((long) (seconds * 1000));
    }

    public void sleep(final long milliseconds) {
        TimerImpl.sleep(milliseconds);
    }

    public void timer(final int seconds) {
        new TimerImpl(true, seconds);
    }

    public boolean timerCheck() {
        if (TimerImpl.timerDuration != 0 && TimerImpl.running) {
            return TimerImpl.getElapsedSeconds() <= TimerImpl.timerDuration;
        } else {
            throw new IllegalStateException("Timer has not been set. See Test().timer()");
        }
    }

    public String timerTimestamp() {
        if (TimerImpl.running) {
            return TimerImpl.getElapsedFormatHHMMSS();
        } else {
            throw new IllegalStateException("Timer has not been set. See Test().timer()");
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
