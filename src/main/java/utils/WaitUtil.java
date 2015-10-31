package utils;


import ui.ILocator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public final class WaitUtil {

    final private WebDriver driver;

    public WaitUtil(final WebDriver driver) {
        this.driver = driver;
    }


    public void until(final Condition condition, final ILocator locator, final int... timeInSeconds) {
        int timeOut;
        if (timeInSeconds.length == 0) {
            timeOut = 10;
        } else {
            timeOut = timeInSeconds[0];
        }
        final WebDriverWait wait = new WebDriverWait(driver, timeOut);
        wait.pollingEvery(500, TimeUnit.MILLISECONDS)
                .withMessage("Couldn't find " + locator)
                .until(condition.getCondition().apply(locator.get()));
    }
}
