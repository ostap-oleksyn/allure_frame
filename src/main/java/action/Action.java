package action;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ui.ILocator;
import ui.LocatorImpl;

import java.util.List;

public final class Action {

    private WebDriver driver;
    private ILocator locator;
    private ILocator clickLocator;
    private int timeOut;
    private String position;

    public Action(final WebDriver driver, final ILocator locator) {
        this.driver = driver;
        this.locator = locator;
    }

    public Action(final WebDriver driver, final ILocator locator, final ILocator clickLocator) {
        this.driver = driver;
        this.locator = locator;
        this.clickLocator = clickLocator;
    }

    public Action at(final int position) {
        this.position = String.valueOf(position);
        return this;
    }

    public Action at(final String position) {
        this.position = position;
        return this;
    }

    public Action wait(final int timeOut) {
        this.timeOut = timeOut;
        return this;
    }

    public void click() {
        new ActionImpl(new LocatorImpl(locator, position), driver, timeOut).click();
    }

    public void mouseOverAndClick() {
        if (clickLocator == null) {
            throw new IllegalArgumentException("Only one locator was passed to Action() method");
        }
        new ActionImpl(new LocatorImpl(locator, position), this.driver, new LocatorImpl(clickLocator, null), timeOut).mouseOverAndClick();
    }

    public void type(final String text) {
        new ActionImpl(new LocatorImpl(locator, position), driver, timeOut).type(text);
    }

    public void submit() {
        new ActionImpl(new LocatorImpl(locator, position), driver, timeOut).submit();
    }

    public WebElement getWebElement() {
        return new ActionImpl(new LocatorImpl(locator, position), driver, timeOut).getWebElement();
    }

    public String getText() {
        return new ActionImpl(new LocatorImpl(locator, position), driver, timeOut).getText();
    }

    public String getAttribute(final String attribute) {
        return new ActionImpl(new LocatorImpl(locator, position), driver, timeOut).getAttribute(attribute);
    }

    public void setAttribute(final String attribute, final String value) {
        new ActionImpl(new LocatorImpl(locator, position), driver, timeOut).setAttribute(attribute, value);
    }

    public boolean isDisplayed() {
        return new ActionImpl(new LocatorImpl(locator, position), driver, timeOut).isDisplayed();
    }

    public int getCount() {
        return new ActionImpl(new LocatorImpl(locator, position), driver, timeOut).getCount();
    }

    public int getNumber() {
        return new ActionImpl(new LocatorImpl(locator, position), driver, timeOut).getNumber();
    }

    public void executeScript(final String javaScript){
        new ActionImpl(new LocatorImpl(locator, position), driver, timeOut).executeScript(javaScript);
    }

    public void selectByText(final String text) {
        new ActionImpl(new LocatorImpl(locator, position), driver, timeOut).selectByText(text);
    }

    public void selectByValue(final String value) {
        new ActionImpl(new LocatorImpl(locator, position), driver, timeOut).selectByValue(value);
    }

    public void selectByIndex(final int index) {
        new ActionImpl(new LocatorImpl(locator, position), driver, timeOut).selectByIndex(index);
    }

    public void deselectByText(final String text) {
        new ActionImpl(new LocatorImpl(locator, position), driver, timeOut).deselectByText(text);
    }

    public void deselectByValue(final String value) {
        new ActionImpl(new LocatorImpl(locator, position), driver, timeOut).deselectByValue(value);
    }

    public void deselectByIndex(final int index) {
        new ActionImpl(new LocatorImpl(locator, position), driver, timeOut).deselectByIndex(index);
    }

    public List<WebElement> getList() {
        return new ActionImpl(new LocatorImpl(locator, position), this.driver, timeOut).getList();
    }
}
