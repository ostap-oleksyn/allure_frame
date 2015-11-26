package tests;

import listeners.TestListener;
import locators.Google;
import locators.Rozetka;
import org.testng.annotations.Listeners;

import static org.assertj.core.api.Assertions.*;

import org.testng.annotations.Test;
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

    @Test(enabled = false)
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
        int firstProductPrice = Action(Rozetka.RESULT_PRODUCT_PRICE).at(randomProduct).getNumber();
        LogUtil.log(firstProduct);
        LogUtil.log(String.valueOf(firstProductPrice));

        resultPage.addProductToCart(randomProduct).closeCart();

        randomProduct = Generate.integer(6, 17);
        LogUtil.log("" + (randomProduct - 1));
        String secondProduct = Action(Rozetka.RESULT_LINK).at(randomProduct).getText();
        int secondProductPrice = Action(Rozetka.RESULT_PRODUCT_PRICE).at(randomProduct).getNumber();
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

    @Test
    @Severity(SeverityLevel.NORMAL)
    public void rozetkaPriceFilterTest() {
        int maxRange = 3000;

        Page().navigateTo("https://rozetka.com.ua");

        Page().executeScript("scroll(0, 750)");

        Action(Rozetka.PC_SIDE_MENU, Rozetka.EBOOK_SUB_MENU).mouseOverAndClick();
        Action(Rozetka.MANUFECTURER).at("PocketBook").click();

        assertThat(Action(Rozetka.ACTIVE_FILTER).at("PocketBook").isDisplayed())
                .as("Manufacturer filter is displayed");


        int filteredProductsCount = Action(Rozetka.PRODUCT_NAME).getCount();

        for (int index = 1; index <= filteredProductsCount; index++) {
            String productName = Action(Rozetka.PRODUCT_NAME).at(index).getText();

            assertThat(productName)
                    .as("Filtered products contain manufacturer name")
                    .contains("PocketBook");
        }

        Action(Rozetka.MAX_PRICE_FILTER).type(String.valueOf(maxRange));
        Action(Rozetka.MAX_PRICE_FILTER).submit();

        assertThat(Action(Rozetka.ACTIVE_FILTER).at(maxRange).isDisplayed())
                .as("Price filter is displayed");

        filteredProductsCount = Action(Rozetka.PRODUCT_NAME).getCount();

        for (int index = 1; index <= filteredProductsCount; index++) {
            int productPrice = Action(Rozetka.PRODUCT_PRICE).at(index).getNumber();

            assertThat(productPrice)
                    .as("Product price filter is applied")
                    .isBetween(1, maxRange);
        }

        Page().takeScreenshot();

        Action(Rozetka.ACTIVE_FILTER).at("PocketBook").click();
        Action(Rozetka.ACTIVE_FILTER).at(String.valueOf(maxRange)).click();

        Page().takeScreenshot();

    }


}
