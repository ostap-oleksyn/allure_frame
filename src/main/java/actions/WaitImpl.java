package actions;


import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.ILocator;
import ui.LocatorImpl;

public class WaitImpl implements IPosition {

    private WebDriver driver;
    private ILocator locator;
    private String position;
    private int timeOut = 30;

    public WaitImpl(WebDriver driver, ILocator locator) {
        this.driver = driver;
        this.locator = locator;
    }

    public WaitImpl(WebDriver driver) {
        this.driver = driver;
    }

    public WaitImpl at(int position) {
        this.position = String.valueOf(position);
        return this;
    }

    public WaitImpl at(String position) {
        this.position = position;
        return this;
    }

    private void checkTimeOut(int... time) {
        if (time.length > 0) {
            timeOut = time[0];
        }
    }

    public void isDisplayed(int... time) {
        checkTimeOut(time);
        new WebDriverWait(driver, timeOut).ignoring(NoSuchElementException.class)
                .withMessage(String.format("Element %s is not visible after %s seconds", new LocatorImpl(locator, position), timeOut))
                .until(ExpectedConditions.visibilityOfElementLocated(new LocatorImpl(locator, position).get()));
    }

    public void notDisplayed(int... time) {
        checkTimeOut(time);
        new WebDriverWait(driver, timeOut)
                .withMessage(String.format("element %s is still visible after %s seconds", new LocatorImpl(locator, position), timeOut))
                .until(ExpectedConditions.invisibilityOfElementLocated(new LocatorImpl(locator, position).get()));
    }

    public void isPresent(int... time) {
        checkTimeOut(time);
        new WebDriverWait(driver, timeOut)
                .withMessage(String.format("element %s is not present after %s seconds", new LocatorImpl(locator, position), timeOut))
                .until(ExpectedConditions.presenceOfElementLocated(new LocatorImpl(locator, position).get()));
    }

    public void isClickable(int... time) {
        checkTimeOut(time);
        new WebDriverWait(driver, timeOut)
                .withMessage(String.format("element %s is not clickable after %s seconds", new LocatorImpl(locator, position), timeOut))
                .until(ExpectedConditions.elementToBeClickable(new LocatorImpl(locator, position).get()));
    }

    public void containsText(String text, int... time) {
        checkTimeOut(time);
        new WebDriverWait(driver, timeOut)
                .withMessage(String.format("Text '%s' is not present in %s after %s seconds", text, new LocatorImpl(locator, position), timeOut))
                .until(ExpectedConditions.textToBePresentInElementLocated(new LocatorImpl(locator, position).get(), text));
    }

    public void notContainsText(String text, int... time) {
        checkTimeOut(time);
        new WebDriverWait(driver, timeOut)
                .withMessage(String.format("Text '%s' is still present in %s after %s seconds", text, new LocatorImpl(locator, position), timeOut))
                .until((ExpectedCondition<Boolean>) webDriver -> !driver.findElement(new LocatorImpl(locator, position).get()).getText().contains(text));
    }
}
