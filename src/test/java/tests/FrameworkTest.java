package tests;

import locators.Google;
import locators.Rozetka;
import org.testng.annotations.Test;
import pageobjects.rozetka.HomePage;
import pageobjects.rozetka.ResultPage;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.model.SeverityLevel;
import runner.TestRunner;
import utils.Generate;
import utils.Log;

import static org.assertj.core.api.Assertions.assertThat;


public class FrameworkTest extends TestRunner {
    @Test(enabled = false)
    @Severity(SeverityLevel.MINOR)
    public void googleTest() {
        page().navigateTo("https://google.com");
        element(Google.SEARCH_FIELD).type("docker");
        element(Google.SEARCH_BUTTON).click();

        verify(1 == 1).withScreenshot().withMessage("test pass message").isTrue();

        String t0 = element(Google.RESULT_LINK).getText();
        String t1 = element(Google.RESULT_LINK).at(2).getText();
        String t2 = element(Google.RESULT_LINK).getText();
        String t3 = element(Google.RESULT_LINK).getText();
        String t4 = element(Google.RESULT_LINK).at(10).getText();

        element(Google.RESULT_LINK).click();
        test().sleep(5);
        getWebDriver().navigate().back();

        element(Google.RESULT_LINK).at(10).click();
        test().sleep(5);
        getWebDriver().navigate().back();

        element(Google.RESULT_LINK).click();
        page().takeScreenshot();

        Log.info(t0);
        Log.info(t1);
        Log.info(t2);
        Log.info(t3);
        Log.info(t4);
    }

    @Test(enabled = false)
    @Severity(SeverityLevel.CRITICAL)
    public void rozetkaTest() {
        page().navigateTo("https://rozetka.com.ua");

        HomePage homePage = new HomePage(getWebDriver());
        homePage.login();

        waitUntil(Rozetka.PERSONAL_LINK).containsText("test");

        String searchTerm = "gtx 960";
        ResultPage resultPage = homePage.doSearchFor(searchTerm);

        final int numberOfResults = element(Rozetka.RESULT_LINK).getCount();

        Log.info("Total results: " + numberOfResults);

        int randomProduct = Generate.integer(1, 5);
        Log.info("" + randomProduct);
        String firstProduct = element(Rozetka.RESULT_LINK).at(randomProduct).getText();
        int firstProductPrice = element(Rozetka.RESULT_PRODUCT_PRICE).at(randomProduct).getNumber();
        Log.info(firstProduct);
        Log.info(String.valueOf(firstProductPrice));

              resultPage.addProductToCart(randomProduct).closeCart();

        randomProduct = Generate.integer(6, 17);
        Log.info("" + (randomProduct - 1));
        String secondProduct = element(Rozetka.RESULT_LINK).at(randomProduct).getText();
        int secondProductPrice = element(Rozetka.RESULT_PRODUCT_PRICE).at(randomProduct).getNumber();
        Log.info(secondProduct);
        Log.info(String.valueOf(secondProductPrice));
        waitUntil(Rozetka.PROCESS_BLOCK).isDisplayed();
        resultPage.addProductToCart(randomProduct - 1);

        int totalPrice = element(Rozetka.CART_TOTAL_COST).getNumber();

        assertThat(totalPrice)
                .as("Total price in cart doesn't match")
                .isEqualTo(firstProductPrice + secondProductPrice);

        resultPage.removeProduct();
        waitUntil(Rozetka.PROCESS_BLOCK).notDisplayed();
        resultPage.removeProduct();
        resultPage.closeCart();
        waitUntil(Rozetka.CART).notDisplayed();

        resultPage.logOut();

        waitUntil(Rozetka.PERSONAL_LINK).notContainsText("test");

        page().takeScreenshot();
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    public void rozetkaPriceFilterTest() {
        int maxRange = 3000;

        page().navigateTo("https://rozetka.com.ua");

        page().executeScript("scroll(0, 750)");

        verify(1 == 1).withScreenshot().withMessage("test message").isFalse();

        element(Rozetka.PC_SIDE_MENU).hover();
        element(Rozetka.EBOOK_SUB_MENU).click();
        element(Rozetka.MANUFECTURER).at("PocketBook").click();


        assertThat(element(Rozetka.ACTIVE_FILTER).at("PocketBook").isDisplayed())
                .as("Manufacturer filter is displayed")
                .isTrue();

        int filteredProductsCount = element(Rozetka.PRODUCT_NAME).getCount();

        for (int index = 1; index <= filteredProductsCount; index++) {
            String productName = element(Rozetka.PRODUCT_NAME).at(index).getText();

            assertThat(productName)
                    .as("Filtered products contain manufacturer name")
                    .contains("PocketBook");
        }

        element(Rozetka.MAX_PRICE_FILTER).type(String.valueOf(maxRange));
        element(Rozetka.MAX_PRICE_FILTER).submit();

        assertThat(element(Rozetka.ACTIVE_FILTER).at(maxRange).isDisplayed())
                .as("Price filter is displayed");


        filteredProductsCount = element(Rozetka.PRODUCT_NAME).getCount();

        for (int index = 1; index <= filteredProductsCount; index++) {
            int productPrice = element(Rozetka.PRODUCT_PRICE).at(index).getNumber();

            assertThat(productPrice)
                    .as("Product price filter is applied")
                    .isBetween(1, maxRange);
        }

        element(Rozetka.ACTIVE_FILTER).at("PocketBook").click();
        element(Rozetka.ACTIVE_FILTER).at(String.valueOf(maxRange)).click();

        page().takeScreenshot();
    }
}
