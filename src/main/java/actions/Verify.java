package actions;


import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;
import runner.TestRunner;

import java.lang.reflect.Field;

public class Verify {

    final private WebDriver driver;
    final private boolean condition;
    private boolean takeScreenshot;
    private String message;


    public Verify(boolean condition, WebDriver driver) {
        this.driver = driver;
        this.condition = condition;
    }

    public Verify withScreenshot() {
        this.takeScreenshot = true;
        return this;
    }

    public Verify withMessage(final String message) {
        this.message = message;
        return this;
    }

    public void isTrue() {
        if (!condition) {
            try {
                final Field field = TestRunner.class.getDeclaredField("isVerificationFailed");
                field.setAccessible(true);
                field.set(null, true);
                logVerfication(message);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public void isFalse() {
        if (condition) {
            try {
                final Field field = TestRunner.class.getDeclaredField("isVerificationFailed");
                field.setAccessible(true);
                field.set(null, true);
                logVerfication(message);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    @Step("FAILED: {0}")
    private void logVerfication(final String message) {
        if (takeScreenshot) {
            new PageActionImpl(driver).takeScreenshot();
        }
    }
}
