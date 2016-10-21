package listeners;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;

import java.lang.reflect.Field;

public class TestResultListener extends TestListenerAdapter {

    @Override
    public void onTestFailure(ITestResult testResult) {
        Object currentClass = testResult.getInstance();
        Field field;
        WebDriver driver = null;
        try {
            field = testResult.getTestClass().getRealClass().getSuperclass().getDeclaredField("driver");
            field.setAccessible(true);
            driver = (WebDriver) field.get(currentClass);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        takeScreenshot(testResult.getMethod().getMethodName(), driver);
    }

    @Step("[FAIL SCREENSHOT]")
    @Attachment(value = "{0}", type = "image/png")
    private byte[] takeScreenshot(String methodName, WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

    }
}
