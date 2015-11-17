package tests;

import listeners.TestListener;
import locators.Google;
import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.model.SeverityLevel;
import runner.TestRunner;
import utils.LogUtil;
import utils.TestUtil;
import utils.WaitUtil;

import java.util.concurrent.TimeUnit;


@Listeners(TestListener.class)
public class GoogleTest extends TestRunner {


    @Test()
    @Severity(SeverityLevel.MINOR)
    public void googleTest() {
        Page().navigateTo("https://google.com");
        Action(Google.SEARCH_FIELD).type("docker");
        Action(Google.SEARCH_BUTTON).click();


        String t0 = Action(Google.RESULT_LINK).getText();
        String t1 = Action(Google.RESULT_LINK).at(2).getText();
        String t2 = Action(Google.RESULT_LINK).getText();
        String t3 = Action(Google.RESULT_LINK).getText();
        String t4 = Action(Google.RESULT_LINK).at(10).getText();


        Action(Google.RESULT_LINK).click();
        TestUtil.sleep(5);
        getDriver().navigate().back();

        Action(Google.RESULT_LINK).at(10).click();
        TestUtil.sleep(5);
        getDriver().navigate().back();

        Action(Google.RESULT_LINK).click();
        Page().takeScreenshot();

        LogUtil.log(t0);
        LogUtil.log(t1);
        LogUtil.log(t2);
        LogUtil.log(t3);
        LogUtil.log(t4);




    }
}
