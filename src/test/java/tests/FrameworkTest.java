package tests;

import listeners.TestListener;
import locators.Google;
import locators.Rozetka;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageobjects.rozetka.HomePage;
import pageobjects.rozetka.ResultPage;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.model.SeverityLevel;
import runner.TestRunner;
import utils.LogUtil;
import utils.TestUtil;


@Listeners(TestListener.class)
public class FrameworkTest extends TestRunner {
    @Test(enabled = false)
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

    @Test()
    @Severity(SeverityLevel.CRITICAL)
    public void rozetkaTest() {
        Page().navigateTo("https://rozetka.com.ua");
        HomePage homePage = new HomePage(getDriver());

        homePage.login();

        WaitUntil(Rozetka.PERSONAL_LINK).hasText("Остап Олексин");

        String searchTerm = "gtx 960";
        ResultPage resultPage = homePage.doSearchFor(searchTerm);

        int numberOfResults = Action(Rozetka.RESULT_LINK).getCount();

        for (int i = 1; i <= numberOfResults; i++){
            String result = Action(Rozetka.RESULT_LINK).at(i).getText();
            LogUtil.log(result);
            Assert.assertTrue(result.toLowerCase().contains(searchTerm));
        }

    }
}
