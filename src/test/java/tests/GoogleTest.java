package tests;

import listeners.TestListener;
import locators.Google;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageobjects.HomePage;
import pageobjects.ResultPage;
import ru.yandex.qatools.allure.annotations.Description;
import runner.TestRunner;
import utils.LogUtil;
import utils.TestUtil;


@Listeners(TestListener.class)
public class GoogleTest extends TestRunner {


    @Description("Google test positive")
    @Test
    public void testGooglePositive() {
        action.navigate("http://www.echoecho.com/htmlforms11.htm");
        action.get(Google.SELECT.at("Bread")).click();

        TestUtil.sleep(5);



    }
}
