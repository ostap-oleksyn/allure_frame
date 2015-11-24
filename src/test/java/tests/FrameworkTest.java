package tests;

import listeners.TestListener;
import locators.Google;
import locators.Rozetka;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;

import pageobjects.rozetka.HomePage;
import pageobjects.rozetka.ResultPage;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.model.SeverityLevel;
import runner.TestRunner;
import utils.Generate;
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

        WaitUntil(Rozetka.PERSONAL_LINK).containsText("Остап Олексин");

        String searchTerm = "gtx 960";
        ResultPage resultPage = homePage.doSearchFor(searchTerm);

        final int numberOfResults = Action(Rozetka.RESULT_LINK).getCount();

        LogUtil.log("Total results: " + numberOfResults);

        int randomProduct = Generate.integer(1, 5);
        LogUtil.log("" + randomProduct);
        String firstProduct = Action(Rozetka.RESULT_LINK).at(randomProduct).getText();
        int firstProductPrice = Action(Rozetka.PRODUCT_PRICE).at(randomProduct).getNumber();
        LogUtil.log(firstProduct);
        LogUtil.log(String.valueOf(firstProductPrice));

        resultPage.addProductToCart(randomProduct).closeCart();

        randomProduct = Generate.integer(6, 17);
        LogUtil.log("" + (randomProduct - 1));
        String secondProduct = Action(Rozetka.RESULT_LINK).at(randomProduct).getText();
        int secondProductPrice = Action(Rozetka.PRODUCT_PRICE).at(randomProduct).getNumber();
        LogUtil.log(secondProduct);
        LogUtil.log(String.valueOf(secondProductPrice));

        resultPage.addProductToCart(randomProduct - 1);

        int totalPrice = Action(Rozetka.CART_TOTAL_COST).getNumber();

        assertThat(totalPrice)
                .as("Total price in cart doesn't match")
                .isEqualTo(firstProductPrice + secondProductPrice);

        resultPage.removeProduct();
        WaitUntil(Rozetka.PROCESS_BLOCK).notVisible();
        resultPage.removeProduct();
        WaitUntil().textIsPresent("Корзина пуста");
        resultPage.closeCart();
        WaitUntil(Rozetka.CART).notVisible();

        resultPage.logOut();

        WaitUntil(Rozetka.PERSONAL_LINK).notContainsText("Остап Олексин");

        Page().takeScreenshot();
    }
}
