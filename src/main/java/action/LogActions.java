package action;


import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;
import ui.LocatorImpl;

public final class LogActions {

    private final WebDriver driver;
    private int timeOut;

    public LogActions(final WebDriver driver, final int timeOut) {
        this.driver = driver;
        this.timeOut = timeOut;
    }

    public LogActions(final WebDriver driver) {
        this.driver = driver;
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
                .withMessage("Element " + locator + " was not found after " + waitTime + " second timeout")
                .until(ExpectedConditions.visibilityOfElementLocated(locator.get()));
    }

    @Step("----------------------SCREENSHOT----------------------")
    @Attachment(value = "Screenshot.png", type = "image/png")
    public byte[] takeScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Step("Navigated to {0}")
    public void navigate(final String url) {
        driver.get(url);
    }

    @Step("Clicked {0}")
    public void click(final LocatorImpl locator) {
        getElement(locator).click();
    }

    @Step("Hovered over {0} and clicked {1}")
    public void mouseOverAndClick(final LocatorImpl overLocator, final LocatorImpl clickLocator) {
        final Actions action = new Actions(driver);
        action.moveToElement(getElement(overLocator));
        action.perform();
        getElement(clickLocator).click();
    }

    @Step("Set {0} attribute ''{1}'' to ''{2}''")
    public void setAttribute(final LocatorImpl locator, final String attribute, final String value) {
        final WebElement element = getElement(locator);
        ((JavascriptExecutor) driver).executeScript(String.format("arguments[0].setAttribute('%s', '%s')", attribute, value), element);
    }

    @Step("Pressed ENTER on {0}")
    public void submit(final LocatorImpl locator) {
        getElement(locator).sendKeys(Keys.ENTER);
    }

    @Step("Typed ''{0}'' into {1}")
    public void type(final String text, final LocatorImpl locator) {
        getElement(locator).clear();
        getElement(locator).sendKeys(text);
    }

    @Step("Typed ''{0}'' into {2}")
    public void type(final String protectedText, final String text, final LocatorImpl locator) {
        getElement(locator).clear();
        getElement(locator).sendKeys(text);
    }

    @Step("Selected {0} with text {}")
    public void selectByText(final LocatorImpl locator, final String text) {
        final Select select = new Select(getElement(locator));
        select.selectByVisibleText(text);
    }

    @Step("Selected {0} at {}")
    public void selectByIndex(final LocatorImpl locator, final int index) {
        final Select select = new Select(getElement(locator));
        select.selectByIndex(index);
    }

    @Step("Selected {0} with value {}")
    public void selectByValue(final LocatorImpl locator, final String value) {
        final Select select = new Select(getElement(locator));
        select.selectByValue(value);
    }

    @Step("Deselected {0} with text {}")
    public void deselectByText(final LocatorImpl locator, final String text) {
        final Select select = new Select(getElement(locator));
        select.deselectByVisibleText(text);
    }

    @Step("Deselected {0} at {}")
    public void deselectByIndex(final LocatorImpl locator, final int index) {
        final Select select = new Select(getElement(locator));
        select.deselectByIndex(index);
    }

    @Step("Deselected {0} with value {}")
    public void deselectByValue(final LocatorImpl locator, final String value) {
        final Select select = new Select(getElement(locator));
        select.deselectByValue(value);
    }

    @Step("Switched to frame {0}")
    public void switchToFrame(final int frameIndex) {
        driver.switchTo().frame(frameIndex);
    }

    @Step("Switched to frame {0}")
    public void switchToFrame(final String frameName) {
        driver.switchTo().frame(frameName);
    }

    @Step("Switched to frame {0}")
    public void switchToFrame(final WebElement element) {
        driver.switchTo().frame(element);
    }

    @Step("Switched to parent frame")
    public void switchToParentFrame() {
        driver.switchTo().parentFrame();
    }

    public void acceptAlert() {
        final String alertText = driver.switchTo().alert().getText();
        acceptAlert(alertText);
    }

    public void dismissAlert() {
        final String alertText = driver.switchTo().alert().getText();
        dismissAlert(alertText);
    }

    @Step("Accepted alert: {0}")
    private void acceptAlert(final String alertText) {
        driver.switchTo().alert().accept();
    }

    @Step("Dismissed alert: {0}")
    private void dismissAlert(final String alertText) {
        driver.switchTo().alert().dismiss();
    }

}
