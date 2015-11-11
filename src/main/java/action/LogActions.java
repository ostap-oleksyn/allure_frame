package action;


import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;
import ui.ILocator;

public final class LogActions {

    private final WebDriver driver;

    public LogActions(final WebDriver driver) {
        this.driver = driver;
    }

    @Step("----------------------SCREENSHOT----------------------")
    @Attachment(value = "Screenshot.png", type = "image/png")
    public byte[] takeScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Step("Navigated to {0}")
    public void navigate(String url) {
        driver.get(url);
    }

    @Step("Clicked {0}")
    public void click(final ILocator locator) {
        driver.findElement(locator.get()).click();
    }

    @Step("Hovered over {0} and clicked {1}")
    public void mouseOverAndClick(final ILocator overLocator, ILocator clickLocator) {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(overLocator.get()));
        action.perform();
        driver.findElement(clickLocator.get()).click();
    }

    @Step("Set {0} attribute ''{1}'' to ''{2}''")
    public void setAttribute(final ILocator locator, final String attribute, final String value) {
        JavascriptExecutor js = (JavascriptExecutor) this.driver;
        WebElement element = driver.findElement(locator.get());
        js.executeScript(String.format("arguments[0].setAttribute('%s', '%s')", attribute, value), element);
    }

    @Step("Typed ''{0}'' into {1}")
    public void type(final String text, final ILocator locator) {
        driver.findElement(locator.get()).clear();
        driver.findElement(locator.get()).sendKeys(text);
    }

    @Step("Typed ''{0}'' into {2}")
    public void type(final String protectedText, final String text, final ILocator locator) {
        driver.findElement(locator.get()).clear();
        driver.findElement(locator.get()).sendKeys(text);
    }

    @Step("Selected {0} with text {}")
    public void selectByText(final ILocator locator, final String text) {
        final Select select = new Select(driver.findElement(locator.get()));
        select.selectByVisibleText(text);
    }

    @Step("Selected {0} at {}")
    public void selectByIndex(final ILocator locator, final int index) {
        final Select select = new Select(driver.findElement(locator.get()));
        select.selectByIndex(index);
    }

    @Step("Selected {0} with value {}")
    public void selectByValue(final ILocator locator, final String value) {
        final Select select = new Select(driver.findElement(locator.get()));
        select.selectByValue(value);
    }

    @Step("Deselected {0} with text {}")
    public void deselectByText(final ILocator locator, final String text) {
        final Select select = new Select(driver.findElement(locator.get()));
        select.deselectByVisibleText(text);
    }

    @Step("Deselected {0} at {}")
    public void deselectByIndex(final ILocator locator, final int index) {
        final Select select = new Select(driver.findElement(locator.get()));
        select.deselectByIndex(index);
    }

    @Step("Deselected {0} with value {}")
    public void deselectByValue(final ILocator locator, final String value) {
        final Select select = new Select(driver.findElement(locator.get()));
        select.deselectByValue(value);
    }
}
