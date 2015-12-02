package utils;


import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.ILocator;
import ui.LocatorImpl;

public final class WaitImpl {

    final private WebDriver driver;
    private ILocator locator;
    private String position;
    private int timeOut = 30;

    public WaitImpl(final WebDriver driver, final ILocator locator) {
        this.driver = driver;
        this.locator = locator;
    }

    public WaitImpl(final WebDriver driver) {
        this.driver = driver;
    }

    public WaitImpl at(final int position) {
        verify();
        this.position = String.valueOf(position);
        return this;
    }

    public WaitImpl at(final String position) {
        verify();
        this.position = position;
        return this;
    }

    private void verify() {
        if (this.locator == null) {
            throw new IllegalArgumentException("No locator was passed to the WaitUntil() method");
        }
    }

    public void isVisible(final int... time) {
        verify();
        if (time.length > 0) {
            timeOut = time[0];
        }
        new WebDriverWait(driver, timeOut).ignoring(ElementNotFoundException.class)
                .withMessage(String.format("Element %s is not visible after %s seconds", new LocatorImpl(locator, position), timeOut))
                .until(ExpectedConditions.visibilityOfElementLocated(new LocatorImpl(locator, position).get()));
    }

    public void notVisible(final int... time) {
        verify();
        if (time.length > 0) {
            timeOut = time[0];
        }
        new WebDriverWait(driver, timeOut)
                .withMessage(String.format("Element %s is still visible after %s seconds", new LocatorImpl(locator, position), timeOut))
                .until(ExpectedConditions.invisibilityOfElementLocated(new LocatorImpl(locator, position).get()));
    }

    public void isPresent(final int... time) {
        verify();
        if (time.length > 0) {
            timeOut = time[0];
        }
        new WebDriverWait(driver, timeOut)
                .withMessage(String.format("Element %s is not present after %s seconds", new LocatorImpl(locator, position), timeOut))
                .until(ExpectedConditions.presenceOfElementLocated(new LocatorImpl(locator, position).get()));
    }

    public void isClickable(final int... time) {
        verify();
        if (time.length > 0) {
            timeOut = time[0];
        }
        new WebDriverWait(driver, timeOut)
                .withMessage(String.format("Element %s is not clickable after %s seconds", new LocatorImpl(locator, position), timeOut))
                .until(ExpectedConditions.elementToBeClickable(new LocatorImpl(locator, position).get()));
    }

    public void containsText(final String text, final int... time) {
        verify();
        if (time.length > 0) {
            timeOut = time[0];
        }
        new WebDriverWait(driver, timeOut)
                .withMessage(String.format("Text '%s' is not present in %s after %s seconds", text, new LocatorImpl(locator, position), timeOut))
                .until(ExpectedConditions.textToBePresentInElementLocated(new LocatorImpl(locator, position).get(), text));
    }

    public void notContainsText(final String text, final int... time) {
        verify();
        if (time.length > 0) {
            timeOut = time[0];
        }
        new WebDriverWait(driver, timeOut)
                .withMessage(String.format("Text '%s' is still present in %s after %s seconds", text, new LocatorImpl(locator, position), timeOut))
                .until((ExpectedCondition<Boolean>) webDriver -> !driver.findElement(new LocatorImpl(locator, position).get()).getText().contains(text));
    }

    public void textIsPresent(final String text, final int... time) {
        if (time.length > 0) {
            timeOut = time[0];
        }
        new WebDriverWait(driver, timeOut)
                .withMessage(String.format("Text '%s' is not present on the page after %s seconds", text, timeOut))
                .until((ExpectedCondition<WebElement>) webDriver -> driver.findElement(By.xpath(".//*[contains(text(),'" + text + "')]")));
    }

}
