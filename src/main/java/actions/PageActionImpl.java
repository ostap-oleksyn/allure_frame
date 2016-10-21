package actions;


import org.openqa.selenium.*;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;

public class PageActionImpl {

    private WebDriver driver;

    public PageActionImpl(WebDriver driver) {
        this.driver = driver;
    }

    @Step("[SCREENSHOT]")
    @Attachment(value = "Screenshot.png", type = "image/png")
    public byte[] takeScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Step("Refreshed page")
    public void refresh() {
        driver.navigate().refresh();
    }

    @Step("Navigated to {0}")
    public void navigate(String url) {
        driver.get(url);
    }

    @Step("Navigated back")
    public void navigateBack() {
        driver.navigate().back();
    }

    @Step("Navigated forward")
    public void navigateForward() {
        driver.navigate().forward();
    }

    @Step("Switched to frame {0}")
    public void switchToFrame(int frameIndex) {
        driver.switchTo().frame(frameIndex);
    }

    @Step("Switched to frame {0}")
    public void switchToFrame(String frameName) {
        driver.switchTo().frame(frameName);
    }

    @Step("Switched to frame {0}")
    public void switchToFrame(WebElement element) {
        driver.switchTo().frame(element);
    }

    @Step("Switched to parent frame")
    public void switchToParentFrame() {
        driver.switchTo().parentFrame();
    }

    @Step("Accepted alert: {0}")
    public void acceptAlert(String alertText) {
        driver.switchTo().alert().accept();
    }

    @Step("Dismissed alert: {0}")
    public void dismissAlert(String alertText) {
        driver.switchTo().alert().dismiss();
    }

    @Step("Executed JavaScript: ''{0}''")
    public void executeScript(String javaScript) {
        ((JavascriptExecutor) driver).executeScript(javaScript);
    }
}
