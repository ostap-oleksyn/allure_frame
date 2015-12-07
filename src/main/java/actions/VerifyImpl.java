package actions;


import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;
import runner.TestRunner;

import java.lang.reflect.Field;

public class VerifyImpl {

    final private WebDriver driver;
    final private boolean condition;
    private boolean takeScreenshot;
    private String message = "";

    public VerifyImpl(final boolean condition, final WebDriver driver) {
        this.driver = driver;
        this.condition = condition;
    }

    public VerifyImpl withScreenshot() {
        this.takeScreenshot = true;
        return this;
    }

    public VerifyImpl withMessage(final String message) {
        this.message = message;
        return this;
    }

    public void isTrue() {
        if (!condition) {
            setVerificationResult();
            logVerification(message);
        }
    }

    public void isFalse() {
        if (condition) {
            setVerificationResult();
            logVerification(message);
        }
    }

    private void setVerificationResult() {
        try {
            final Field field = TestRunner.class.getDeclaredField("isVerificationFailed");
            field.setAccessible(true);
            field.set(null, true);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Step("VERIFICATION FAILED: {0}")
    private void logVerification(final String message) {
        if (takeScreenshot) {
            new PageActionImpl(driver).takeScreenshot();
        }
    }
}
