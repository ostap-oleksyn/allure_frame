package actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ui.ILocator;
import ui.LocatorImpl;

import java.util.List;

public final class ElementAction {

    private final WebDriver driver;
    private final ILocator locator;
    private ILocator clickLocator;
    private int timeOut;
    private String position;

    public ElementAction(final WebDriver driver, final ILocator locator) {
        this.driver = driver;
        this.locator = locator;
    }

    public ElementAction(final WebDriver driver, final ILocator locator, final ILocator clickLocator) {
        this.driver = driver;
        this.locator = locator;
        this.clickLocator = clickLocator;
    }

    public ElementAction at(final int position) {
        this.position = String.valueOf(position);
        return this;
    }

    public ElementAction at(final String position) {
        this.position = position;
        return this;
    }

    public ElementAction wait(final int timeOut) {
        this.timeOut = timeOut;
        return this;
    }

    public void click() {
        new ElementActionImpl(new LocatorImpl(locator, position), driver, timeOut).click();
    }

    public void mouseOverAndClick() {
        if (clickLocator == null) {
            throw new IllegalArgumentException("Only one locator was passed to Action() method");
        }
        new ElementActionImpl(new LocatorImpl(locator, position),new LocatorImpl(clickLocator, null), this.driver, timeOut).mouseOverAndClick();
    }

    public void type(final String text) {
        new ElementActionImpl(new LocatorImpl(locator,position),driver, timeOut).type(text);
    }

    public void submit() {
        new ElementActionImpl(new LocatorImpl(locator, position), driver, timeOut).submit();
    }

    public WebElement getWebElement() {
        return new ElementActionImpl(new LocatorImpl(locator, position), driver, timeOut).getWebElement();
    }

    public String getText() {
        return new ElementActionImpl(new LocatorImpl(locator, position), driver, timeOut).getText();
    }

    public String getAttribute(final String attribute) {
        return new ElementActionImpl(new LocatorImpl(locator, position), driver, timeOut).getAttribute(attribute);
    }

    public void setAttribute(final String attribute, final String value) {
        new ElementActionImpl(new LocatorImpl(locator, position), driver, timeOut).setAttribute(attribute, value);
    }

    public boolean isDisplayed() {
        //TODO - move out somewhere?
        return new ElementActionImpl(new LocatorImpl(locator, position), driver, timeOut).isDisplayed();
    }

    public int getCount() {
        return new ElementActionImpl(new LocatorImpl(locator, position), driver, timeOut).getCount();
    }

    public int getNumber() {
        return new ElementActionImpl(new LocatorImpl(locator, position), driver, timeOut).getNumber();
    }

    public void executeScript(final String javaScript){
        new ElementActionImpl(new LocatorImpl(locator, position), driver, timeOut).executeScript(javaScript);
    }

    public List<WebElement> getList() {
        return new ElementActionImpl(new LocatorImpl(locator, position), this.driver, timeOut).getList();
    }
}
