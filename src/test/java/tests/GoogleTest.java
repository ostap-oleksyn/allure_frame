package tests;

import listeners.TestListener;
import locators.Gmail;
import locators.Google;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import runner.TestRunner;
import utils.Generate;
import utils.LogUtil;
import utils.TestUtil;


@Listeners(TestListener.class)
public class GoogleTest extends TestRunner {


    @Description("Google test positive")
    @Test(enabled = false)
    public void testGooglePositive() {
        action().navigate("https://gmail.com");
        action().get(Gmail.MAIL_FIELD).type("ostap.oleksyn");
        action().get(Gmail.NEXT_BUTTON).click();

        final String mailName = action().get(Gmail.EMAIL_DISPLAY).getText();

        Assert.assertTrue("ostap.oleksyn@gmail.com".equals(mailName));

        action().get(Gmail.PASSWORD_FIELD).type("Omnius!$23");
        action().get(Gmail.SUBMIT_BUTTON).click();

        Assert.assertTrue(action().get(Gmail.SEARCH_FIELD).isDisplayed());

        action().get(Gmail.NEW_LETTER_BUTTON).click();

        action().get(Gmail.RECIEVER_FIELD).type("ostap.olkeyn@gmail.com");

        String subject = "SUCCESS!!!";

        action().get(Gmail.SUBJECT_FIELD).type(subject);
        action().get(Gmail.LETTER_CONTENT).type(Generate.loremIpsum(500));
        action().get(Gmail.SUBMIT_BUTTON).click();

        action().get(Gmail.REFRESH_BUTTON).click();

        String letterSubject =  action().get(Gmail.LETTERS_TABLE_SUBJECT.at(1)).getText();

        Assert.assertTrue(subject.equals(letterSubject));

        action().takeScreenshot();
    }

    @Test()
    public void googleTest1() {
        action().navigate("https://google.com");
        action().get(Google.SEARCH_FIELD).type("docker");
        action().get(Google.SEARCH_BUTTON).click();

        String t0 = action().get(Google.RESULT_LINK).getText();
        String t1 = action().get(Google.RESULT_LINK.at(2)).getText();
        String t2 = action().get(Google.RESULT_LINK).getText();
        String t3 = action().get(Google.RESULT_LINK).getText();
        String t4 = action().get(Google.RESULT_LINK.at(10)).getText();


        action().get(Google.RESULT_LINK).click();
        TestUtil.sleep(5);
        getDriver().navigate().back();

        action().get(Google.RESULT_LINK.at(10)).click();
        TestUtil.sleep(5);
        getDriver().navigate().back();

        action().get(Google.RESULT_LINK).click();
        action().takeScreenshot();

        LogUtil.log(t0);
        LogUtil.log(t1);
        LogUtil.log(t2);
        LogUtil.log(t3);
        LogUtil.log(t4);
    }
}
