package actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ui.ILocator;
import ui.LocatorImpl;

import java.util.List;

public class ElementAction implements IPosition {

    private WebDriver driver;
    private ILocator locator;
    private int timeOut;
    private String position;

    public ElementAction(WebDriver driver, ILocator locator) {
        this.driver = driver;
        this.locator = locator;
    }

    public ElementAction at(int position) {
        this.position = String.valueOf(position);
        return this;
    }

    public ElementAction at(String position) {
        this.position = position;
        return this;
    }

    public ElementAction wait(int timeOut) {
        this.timeOut = timeOut;
        return this;
    }

    public void click() {
        new ElementActionImpl(new LocatorImpl(locator, position), driver, timeOut).click();
    }

    public void hover() {
        new ElementActionImpl(new LocatorImpl(locator, position), this.driver, timeOut).hover();
    }

    public void scrollTo() {
        new ElementActionImpl(new LocatorImpl(locator, position), this.driver, timeOut).scrollTo();
    }

    public void type(String text) {
        new ElementActionImpl(new LocatorImpl(locator, position), driver, timeOut).type(text);
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

    public String getAttribute(String attribute) {
        return new ElementActionImpl(new LocatorImpl(locator, position), driver, timeOut).getAttribute(attribute);
    }

    public void setAttribute(String attribute, String value) {
        new ElementActionImpl(new LocatorImpl(locator, position), driver, timeOut).setAttribute(attribute, value);
    }

    public int getCount() {
        return new ElementActionImpl(new LocatorImpl(locator, position), driver, timeOut).getCount();
    }

    public int getNumber() {
        return new ElementActionImpl(new LocatorImpl(locator, position), driver, timeOut).getNumber();
    }

    public void executeScript(String javaScript) {
        new ElementActionImpl(new LocatorImpl(locator, position), driver, timeOut).executeScript(javaScript);
    }

    public List<WebElement> getList() {
        return new ElementActionImpl(new LocatorImpl(locator, position), this.driver, timeOut).getList();
    }

    public boolean isDisplayed() {
        return new ElementActionImpl(new LocatorImpl(locator, position), driver, timeOut).isDisplayed();
    }

    public boolean isEnabled() {
        return new ElementActionImpl(new LocatorImpl(locator, position), driver, timeOut).isEnabled();
    }

    public boolean containsText(String text) {
        return new ElementActionImpl(new LocatorImpl(locator, position), driver, timeOut).containsText(text);
    }

    public void selectByText(String text) {
        new ElementActionImpl(new LocatorImpl(locator, position), driver, timeOut).selectByText(text);
    }

    public void selectByValue(String value) {
        new ElementActionImpl(new LocatorImpl(locator, position), driver, timeOut).selectByValue(value);
    }

    public void selectByIndex(int index) {
        new ElementActionImpl(new LocatorImpl(locator, position), driver, timeOut).selectByIndex(index);
    }
}
