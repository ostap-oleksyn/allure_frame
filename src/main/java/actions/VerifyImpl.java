package actions;


import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;
import utils.TestResult;

public class VerifyImpl {

    private WebDriver driver;
    private boolean condition;
    private TestResult result;
    private boolean withScreenshot;
    private boolean withMessage;
    private String message = "";

    public VerifyImpl(boolean condition, WebDriver driver, TestResult result) {
        this.driver = driver;
        this.condition = condition;
        this.result = result;
    }

    public VerifyImpl withScreenshot() {
        this.withScreenshot = true;
        return this;
    }

    public VerifyImpl withMessage(String message) {
        this.withMessage = true;
        this.message = message;
        return this;
    }

    public void isTrue() {
        if (!condition) {
            result.fail();
            logFailedMessage(message);
        } else if (withMessage){
            logPassedMessage(message);
        }
    }

    public void isFalse() {
        if (condition) {
            result.fail();
            logFailedMessage(message);
        } else if (withMessage){
            logPassedMessage(message);
        }
    }

    @Step("VERIFICATION FAILED: {0}")
    private void logFailedMessage(String message) {
        if (withScreenshot) {
            new PageActionImpl(driver).takeScreenshot();
        }
    }

    @Step("VERIFICATION PASSED: {0}")
    private void logPassedMessage(String message) {
        if (withScreenshot) {
            new PageActionImpl(driver).takeScreenshot();
        }
    }
}
