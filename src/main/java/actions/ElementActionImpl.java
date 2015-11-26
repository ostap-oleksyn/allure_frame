package actions;


import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;
import ui.LocatorImpl;

import java.util.List;

public final class ElementActionImpl {

    private final WebDriver driver;
    private final LocatorImpl locator;
    private LocatorImpl secondaryLocator;
    private final int timeOut;

    public ElementActionImpl(final LocatorImpl locator, final WebDriver driver, final int timeOut) {
        this.locator = locator;
        this.driver = driver;
        this.timeOut = timeOut;
    }

    public ElementActionImpl(final LocatorImpl locator, final LocatorImpl secondaryLocator, final WebDriver driver, final int timeOut) {
        this.locator = locator;
        this.secondaryLocator = secondaryLocator;
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
                .withMessage("Element " + locator + " was not found after " + waitTime + " seconds timeout")
                .until(ExpectedConditions.visibilityOfElementLocated(locator.get()));
    }

    public WebElement getWebElement() {
        return getElement(locator);
    }

    public List<WebElement> getList() {
        getElement(locator);
        return driver.findElements(locator.get());
    }

    public String getText() {
        return getElement(locator).getText();
    }

    public String getAttribute(final String attribute) {
        return getElement(locator).getAttribute(attribute);
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

    public void click() {
        click(this.locator);
    }

    public void mouseOverAndClick() {
        mouseOverAndClick(locator, secondaryLocator);
    }

    public void type(final String text){
        if (locator.toString().toLowerCase().contains("password")) {
            final String protectedText = text.replaceAll(".?", "*");
           type(protectedText, text, locator);
        } else {
            type(text, locator);
        }
    }

    public void submit(){
        submit(this.locator);
    }

    @Step("Clicked {0}")
    private void click(final LocatorImpl locator) {
        getElement(locator).click();
    }

    @Step("Hovered over {0} and clicked {1}")
    private void mouseOverAndClick(final LocatorImpl overLocator, final LocatorImpl clickLocator) {
        final Actions action = new Actions(driver);
        action.moveToElement(getElement(overLocator));
        action.perform();
        getElement(clickLocator).click();
    }

    @Step("Set {0} attribute ''{1}'' to ''{2}''")
    public void setAttribute(final String attribute, final String value) {
        final WebElement element = getElement(locator);
        ((JavascriptExecutor) driver).executeScript(String.format("arguments[0].setAttribute('%s', '%s')", attribute, value), element);
    }

    @Step("Pressed ENTER on {0}")
    private void submit(final LocatorImpl locator) {
        getElement(locator).sendKeys(Keys.ENTER);
    }

    @Step("Typed ''{0}'' into {1}")
    private void type(final String text, final LocatorImpl locator) {
        getElement(locator).clear();
        getElement(locator).sendKeys(text);
    }

    @Step("Typed ''{0}'' into {2}")
    private void type(final String protectedText, final String text, final LocatorImpl locator) {
        getElement(locator).clear();
        getElement(locator).sendKeys(text);
    }

    @Step("Executed JavaScript: ''{0}'' on {1}")
    public void executeScript(final String javaScript) {
        ((JavascriptExecutor) driver).executeScript(javaScript, getElement(locator));
    }

}
