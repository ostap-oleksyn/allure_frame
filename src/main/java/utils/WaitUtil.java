package utils;


import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.ILocator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public final class WaitUtil {

    final private WebDriver driver;

    public WaitUtil(final WebDriver driver) {
        this.driver = driver;
    }

    @Deprecated
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

    public void elementIsVisible(final ILocator locator, final int... time) {
        int timeOut = 30;
        if (time.length > 0) {
            timeOut = time[1];
        }
        new WebDriverWait(driver, timeOut).ignoring(ElementNotFoundException.class)
                .withMessage(String.format("Element %s is not visible after %s seconds", locator, timeOut))
                .until(ExpectedConditions.visibilityOfElementLocated(locator.get()));
    }

    public void elementIsInvisible(final ILocator locator, final int... time) {
        int timeOut = 30;
        if (time.length > 0) {
            timeOut = time[1];
        }
        new WebDriverWait(driver, timeOut)
                .withMessage(String.format("Element %s is visible after %s seconds", locator, timeOut))
                .until(ExpectedConditions.invisibilityOfElementLocated(locator.get()));
    }

    public void textIsPresent(final ILocator locator, final String text, final int... time) {
        int timeOut = 30;
        if (time.length > 0) {
            timeOut = time[1];
        }
        new WebDriverWait(driver, timeOut)
                .withMessage(String.format("Text '%s' is not present in %s after %s seconds", text, locator, timeOut))
                .until(ExpectedConditions.textToBePresentInElementLocated(locator.get(), text));
    }

    public void pageIsReady() {
        new WebDriverWait(driver, 30)
                .until((ExpectedCondition<Boolean>) webDriver -> ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("loading"));
    }
}
