package actions;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ui.ILocator;

public class PageAction {

    private WebDriver driver;

    public PageAction(WebDriver driver) {
        this.driver = driver;
    }

    public void refresh() {
        new PageActionImpl(this.driver).refresh();
    }

    public void navigateTo(String url) {
        new PageActionImpl(this.driver).navigate(url);
    }

    public void navigateBack() {
        new PageActionImpl(this.driver).navigateBack();
    }

    public void navigateForward() {
        new PageActionImpl(this.driver).navigateForward();
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public void switchToFrame(int frameIndex) {
        new PageActionImpl(driver).switchToFrame(frameIndex);
    }

    public void switchToFrame(String frameName) {
        new PageActionImpl(driver).switchToFrame(frameName);
    }

    public void switchToFrame(ILocator locator) {
        WebElement element = new ElementAction(driver, locator).getWebElement();
        new PageActionImpl(driver).switchToFrame(element);
    }

    public void switchToParentFrame() {
        new PageActionImpl(driver).switchToParentFrame();
    }

    public void acceptAlert() {
        String alertText = driver.switchTo().alert().getText();
        new PageActionImpl(driver).acceptAlert(alertText);
    }

    public void dismissAlert() {
        String alertText = driver.switchTo().alert().getText();
        new PageActionImpl(driver).dismissAlert(alertText);
    }

    public String getAlertText() {
        return driver.switchTo().alert().getText();
    }

    public void executeScript(String javaScript) {
        new PageActionImpl(driver).executeScript(javaScript);
    }

    public void takeScreenshot() {
        new PageActionImpl(this.driver).takeScreenshot();
    }

    public boolean hasText(String text) {
        return !driver.findElements(By.xpath(".//*[contains(text(),'" + text + "')]")).isEmpty();
    }

    public String getPageSource() {
        return driver.getPageSource();
    }
}
