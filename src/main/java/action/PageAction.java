package action;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public final class PageAction {

    private final WebDriver driver;

    public PageAction(final WebDriver driver) {
        this.driver = driver;
    }

    public void navigateTo(final String url) {
        new LogActions(this.driver).navigate(url);
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public void switchToFrame(final int frameIndex) {
       new LogActions(driver).switchToFrame(frameIndex);
    }

    public void switchToFrame(final String frameName) {
        new LogActions(driver).switchToFrame(frameName);
    }

    public void switchToFrame(final WebElement element) {
        new LogActions(driver).switchToFrame(element);
    }

    public void switchToParentFrame() {
        new LogActions(driver).switchToParentFrame();
    }

    public void acceptAlert() {
        new LogActions(driver).acceptAlert();
    }

    public void dismissAlert() {
        new LogActions(driver).dismissAlert();
    }

    public String getAlertText() {
        return driver.switchTo().alert().getText();
    }

    public void takeScreenshot() {
        new LogActions(this.driver).takeScreenshot();
    }
}
