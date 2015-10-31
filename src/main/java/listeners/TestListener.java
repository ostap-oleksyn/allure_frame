package listeners;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;
import runner.TestRunner;
import utils.LogUtil;

public class TestListener extends TestListenerAdapter {
    @Override
    public void onTestSuccess(ITestResult tr) {
        LogUtil.log("-------------------------------TEST FINISHED-------------------------------");
    }

    @Override
    public void onTestFailure(ITestResult tr) {
        final Object currentClass = tr.getInstance();
        final WebDriver driver = ((TestRunner) currentClass).getDriver();
        takeScreenshot(tr.getMethod().getMethodName(), driver);
    }

    @Override
    public void onStart(ITestContext testContext) {
        LogUtil.log("-------------------------------TEST STARTED-------------------------------");
    }


    @Step("-------------------------------FAIL SCREENSHOT-------------------------------")
    @Attachment(value = "{0}", type = "image/png")
    public byte[] takeScreenshot(String methodName, WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

    }
}
