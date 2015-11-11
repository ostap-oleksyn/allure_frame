package tests;

import listeners.TestListener;
import locators.Google;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import runner.TestRunner;


@Listeners(TestListener.class)
public class GoogleTest extends TestRunner {


    @Description("Google test")
    @Test
    public void testGoogle() {
        action.get(Google.SEARCH_FIELD).type("abnfdabfdbafdb");
        waitUntil.textIsPresent(Google.GOOGLE_LOGO, "bla");
    }
}
