package utils;


import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.ILocator;
import ui.LocatorImpl;

public final class WaitUtil {

    final private WebDriver driver;
    final private ILocator locator;
    private String position;
    private int timeOut = 30;

    public WaitUtil(final WebDriver driver, final ILocator locator) {
        this.driver = driver;
        this.locator = locator;
    }

    public WaitUtil at(final int position) {
        this.position = String.valueOf(position);
        return this;
    }

    public WaitUtil at(final String position) {
        this.position = position;
        return this;
    }

    public void isVisible(final int... time) {
        if (time.length > 0) {
            timeOut = time[0];
        }
        new WebDriverWait(driver, timeOut).ignoring(ElementNotFoundException.class)
                .withMessage(String.format("Element %s is not visible after %s seconds", new LocatorImpl(locator, position), timeOut))
                .until(ExpectedConditions.visibilityOfElementLocated(new LocatorImpl(locator, position).get()));
    }

    public void isInvisible(final int... time) {
        if (time.length > 0) {
            timeOut = time[0];
        }
        new WebDriverWait(driver, timeOut)
                .withMessage(String.format("Element %s is still visible after %s seconds", new LocatorImpl(locator, position), timeOut))
                .until(ExpectedConditions.invisibilityOfElementLocated(new LocatorImpl(locator, position).get()));
    }

    public void isPresent(final int... time) {
        if (time.length > 0) {
            timeOut = time[0];
        }
        new WebDriverWait(driver, timeOut)
                .withMessage(String.format("Element %s is not present after %s seconds", new LocatorImpl(locator, position), timeOut))
                .until(ExpectedConditions.presenceOfElementLocated(new LocatorImpl(locator, position).get()));
    }

    public void hasText(final String text, final int... time) {
        if (time.length > 0) {
            timeOut = time[0];
        }
        new WebDriverWait(driver, timeOut)
                .withMessage(String.format("Text '%s' is not present in %s after %s seconds", text, new LocatorImpl(locator, position), timeOut))
                .until(ExpectedConditions.textToBePresentInElementLocated(new LocatorImpl(locator, position).get(), text));
    }


}
