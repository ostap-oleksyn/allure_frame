package tests;

import listeners.TestListener;
import locators.Google;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageobjects.HomePage;
import ru.yandex.qatools.allure.annotations.Description;
import runner.TestRunner;

import static tests.CustomAssert.*;
//import static org.assertj.core.api.Assertions.*;
import static utils.LogUtil.log;

@Listeners(TestListener.class)
public class GoogleTest extends TestRunner {


    @Description("Google test")
    @Test
    public void testGoogle()  {



        action.navigate("https://www.amazon.com/");
        assertThat(4).isEqualTo(4).overridingErrorMessage("Succses!!!!!!!!!!!!!!!!!!!!!!");

        assertThat(action.get(Google.GOOGLE_LOGO).isDisplayed(10))
                .withFailMessage("Nav Menu is Displayed");

        action.get(Google.NAV_MENU).setAttribute("style", "display:block");

        log(action.get(Google.NAV_MENU).getAttribute("style"));
        assertThat(5).withFailMessage("This is assertion message 2").isEqualTo(5);

        action.mouseOverAndClick(Google.ACCOUNT_MENU, Google.START_HERE);
        action.takeScreenshot();

        assertThat(14).withFailMessage("This is assertion message 3").isEqualTo(2);


    }
}
