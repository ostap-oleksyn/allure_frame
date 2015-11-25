package action;


import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.LocatorImpl;

import java.util.List;


public final class ActionImpl {

    private final LocatorImpl locator;
    private LocatorImpl locator1;
    private final WebDriver driver;
    private final int timeOut;

    public ActionImpl(final LocatorImpl locator, final WebDriver driver, final int timeOut) {
        this.locator = locator;
        this.driver = driver;
        this.timeOut = timeOut;
    }

    public ActionImpl(final LocatorImpl locator, final WebDriver driver, final LocatorImpl locator1, final int timeOut) {
        this.locator = locator;
        this.locator1 = locator1;
        this.driver = driver;
        this.timeOut = timeOut;
    }

    private WebElement getElement(final LocatorImpl locator) {
        int waitTime;
        if (this.timeOut > 0) {
            waitTime = timeOut;
        } else {
            waitTime = 15;
        }

        return new WebDriverWait(driver, waitTime)
                .ignoring(NoSuchElementException.class)
                .withMessage("Element " + locator + " was not visible after " + waitTime + " seconds timeout")
                .until(ExpectedConditions.visibilityOfElementLocated(locator.get()));
    }

    public WebElement getWebElement() {
        return getElement(locator);
    }

    public List<WebElement> getList() {
        getElement(locator);
        return driver.findElements(locator.get());
    }

    public void type(final String text) {
        if (locator.toString().toLowerCase().contains("password")) {
            final String protectedText = text.replaceAll(".?", "*");
            new LogActions(this.driver, timeOut).type(protectedText, text, locator);
        } else {
            new LogActions(this.driver, timeOut).type(text, locator);
        }
    }

    public void submit() {
        new LogActions(driver, timeOut).submit(locator);
    }

    public String getText() {
        return getElement(locator).getText();
    }

    public String getAttribute(final String attribute) {
        return getElement(locator).getAttribute(attribute);
    }

    public void setAttribute(final String attribute, final String value) {
        new LogActions(this.driver, timeOut).setAttribute(locator, attribute, value);
    }

    public boolean isDisplayed() {
        boolean isDisplayed;
        try {
            isDisplayed = getElement(locator).isDisplayed();
        } catch (TimeoutException e) {
            isDisplayed = false;
        }
        return isDisplayed;
    }

    public int getCount() {
        return getList().size();
    }

    public int getNumber() {
        final String text = getElement(locator).getText().replaceAll("\\D", "");
        if (text.length() == 0) {
            throw new IllegalStateException("Element's text doesn't contain any numbers.");
        }
        return Integer.parseInt(text);
    }

    public void mouseOverAndClick() {
        new LogActions(this.driver, timeOut).mouseOverAndClick(locator, locator1);
    }

    public void click() {
        new LogActions(this.driver, timeOut).click(locator);
    }

    public void selectByText(final String text) {
        new LogActions(this.driver, timeOut).selectByText(locator, text);
    }

    public void selectByValue(final String value) {
        new LogActions(this.driver, timeOut).selectByValue(locator, value);
    }

    public void selectByIndex(final int index) {
        new LogActions(this.driver, timeOut).selectByIndex(locator, index);
    }

    public void deselectByText(final String text) {
        new LogActions(this.driver, timeOut).deselectByText(locator, text);
    }

    public void deselectByValue(final String value) {
        new LogActions(this.driver, timeOut).deselectByValue(locator, value);
    }

    public void deselectByIndex(final int index) {
        new LogActions(this.driver, timeOut).deselectByIndex(locator, index);
    }


}
