package action;


import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.ILocator;
import utils.LogUtil;

import java.util.concurrent.TimeUnit;


public final class ActionImpl {

    final private ILocator locator;
    private ILocator locator1;
    final private WebDriver driver;

    public ActionImpl(final ILocator locator, final WebDriver driver) {
        this.locator = locator;
        this.driver = driver;
    }

    public ActionImpl(final ILocator locator, final WebDriver driver, final ILocator locator1) {
        this.locator = locator;
        this.locator1 = locator1;
        this.driver = driver;
    }

    private WebElement getElement(final ILocator locator) {
        return new WebDriverWait(driver, 15)
                .ignoring(NoSuchElementException.class)
                .withMessage("Element " + locator + " was not found after default 30 second timeout")
                .until(ExpectedConditions.visibilityOfElementLocated(locator.get()));
    }

    public void type(final String text) {
        if (locator.toString().toLowerCase().contains("password")) {
            final String protectedText = text.replaceAll(".?", "*");
            new LogActions(this.driver).type(protectedText, text, locator);
        } else {
            new LogActions(this.driver).type(text, locator);
        }
    }

    public String getText() {
        return getElement(locator).getText();
    }

    public String getAttribute(final String attribute) {
        return getElement(locator).getAttribute(attribute);
    }

    public void setAttribute(final String attribute, final String value) {
        new LogActions(this.driver).setAttribute(locator, attribute, value);
    }
    //TODO - Remove implicit waits and refactor!!!
    public boolean isDisplayed(final int... timeout) {

        boolean isDisplayed;
        if (timeout.length > 0) {
            driver.manage().timeouts().implicitlyWait(timeout.length, TimeUnit.SECONDS);
        }
        try {
            isDisplayed = driver.findElement(locator.get()).isDisplayed();
        } catch (NoSuchElementException e) {
            LogUtil.log("FAIL: " + locator.toString() + " is not displayed");
            isDisplayed = false;
        }
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return isDisplayed;
    }

    public int getCount() {
        return driver.findElements(locator.get()).size();
    }

    public Long getNumber() {
        final String text = getElement(locator).getText().replaceAll("\\D", "");
        if (text.length() == 0) {
            throw new IllegalStateException("Element has no numbers in it.");
        }
        return Long.parseLong(text);
    }

    public void mouseOverAndClick() {
        new LogActions(this.driver).mouseOverAndClick(locator, locator1);
    }

    public void click() {
        new LogActions(this.driver).click(locator);
    }

    public void selectByText(final String text) {
        new LogActions(this.driver).selectByText(locator, text);
    }

    public void selectByValue(final String value) {
        new LogActions(this.driver).selectByValue(locator, value);
    }

    public void selectByIndex(final int index) {
        new LogActions(this.driver).selectByIndex(locator, index);
    }

    public void deselectByText(final String text) {
        new LogActions(this.driver).deselectByText(locator, text);
    }

    public void deselectByValue(final String value) {
        new LogActions(this.driver).deselectByValue(locator, value);
    }

    public void deselectByIndex(final int index) {
        new LogActions(this.driver).deselectByIndex(locator, index);
    }


}
