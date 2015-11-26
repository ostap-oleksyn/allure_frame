package actions;


import org.openqa.selenium.*;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;

public final class PageActionImpl {

    private final WebDriver driver;

    public PageActionImpl(final WebDriver driver) {
        this.driver = driver;
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

    @Step("Accepted alert: {0}")
    public void acceptAlert(final String alertText) {
        driver.switchTo().alert().accept();
    }

    @Step("Dismissed alert: {0}")
    public void dismissAlert(final String alertText) {
        driver.switchTo().alert().dismiss();
    }

    @Step("Executed JavaScript: ''{0}''")
    public void executeScript(final String javaScript) {
        ((JavascriptExecutor) driver).executeScript(javaScript);
    }


}
