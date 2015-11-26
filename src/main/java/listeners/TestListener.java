package listeners;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;
import runner.TestRunner;

public class TestListener extends TestListenerAdapter {

    @Override
    public void onTestFailure(final ITestResult tr) {
        final Object currentClass = tr.getInstance();
        final WebDriver driver = ((TestRunner) currentClass).getDriver();
        takeScreenshot(tr.getMethod().getMethodName(), driver);
    }

    @Step("-------------------------------FAIL SCREENSHOT-------------------------------")
    @Attachment(value = "{0}", type = "image/png")
    public byte[] takeScreenshot(final String methodName, final WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

    }
}
