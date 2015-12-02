package utils;


import actions.PageAction;
import exceptions.TestFailException;
import org.openqa.selenium.WebDriver;
import org.testng.SkipException;

public final class TestImpl {

    private final WebDriver driver;

    public TestImpl(final WebDriver driver) {
        this.driver = driver;
    }

    public void skip(final String message) {
        LogUtil.log("TEST SKIPPED: " + message);
        throw new SkipException(message);
    }

    public void skip(final String message, final boolean takeScreenshot) {
        LogUtil.log("TEST SKIPPED: " + message);
        if (takeScreenshot){
            new PageAction(driver).takeScreenshot();
        }
        throw new SkipException(message);
    }

    public void fail(final String message) {
        throw new TestFailException(message);
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
}
