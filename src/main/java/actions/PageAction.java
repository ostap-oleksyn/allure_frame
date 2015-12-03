package actions;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ui.ILocator;
import ui.LocatorImpl;

public final class PageAction {

    private final WebDriver driver;

    public PageAction(final WebDriver driver) {
        this.driver = driver;
    }

    public void navigateTo(final String url) {
        new PageActionImpl(this.driver).navigate(url);
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public void switchToFrame(final int frameIndex) {
        new PageActionImpl(driver).switchToFrame(frameIndex);
    }

    public void switchToFrame(final String frameName) {
        new PageActionImpl(driver).switchToFrame(frameName);
    }

    public void switchToFrame(final ILocator locator) {
        final WebElement element = new ElementAction(driver, locator).getWebElement();
        new PageActionImpl(driver).switchToFrame(element);
    }

    public void switchToParentFrame() {
        new PageActionImpl(driver).switchToParentFrame();
    }

    public void acceptAlert() {
        final String alertText = driver.switchTo().alert().getText();
        new PageActionImpl(driver).acceptAlert(alertText);
    }

    public void dismissAlert() {
        final String alertText = driver.switchTo().alert().getText();
        new PageActionImpl(driver).dismissAlert(alertText);
    }

    public String getAlertText() {
        return driver.switchTo().alert().getText();
    }

    public void executeScript(final String javaScript) {
        new PageActionImpl(driver).executeScript(javaScript);
    }

    public void takeScreenshot() {
        new PageActionImpl(this.driver).takeScreenshot();
    }

    public boolean hasText(final String text){
        return !driver.findElements(By.xpath(".//*[contains(text(),'" + text + "')]")).isEmpty();
    }
}
