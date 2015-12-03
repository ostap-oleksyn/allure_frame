package tests;

import actions.Verify;
import listeners.TestListener;
import listeners.VerifyListener;
import locators.Google;
import locators.Rozetka;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageobjects.rozetka.HomePage;
import pageobjects.rozetka.ResultPage;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.model.SeverityLevel;
import runner.TestRunner;
import utils.Generate;
import utils.LogUtil;

import static org.assertj.core.api.Assertions.assertThat;


@Listeners({TestListener.class, VerifyListener.class})
public class FrameworkTest extends TestRunner {
    @Test(enabled = false)
    @Severity(SeverityLevel.MINOR)
    public void googleTest() {
        Page().navigateTo("https://google.com");
        Element(Google.SEARCH_FIELD).type("docker");
        Element(Google.SEARCH_BUTTON).click();

        String t0 = Element(Google.RESULT_LINK).getText();
        String t1 = Element(Google.RESULT_LINK).at(2).getText();
        String t2 = Element(Google.RESULT_LINK).getText();
        String t3 = Element(Google.RESULT_LINK).getText();
        String t4 = Element(Google.RESULT_LINK).at(10).getText();

        Element(Google.RESULT_LINK).click();
        Test().sleep(5);
        getDriver().navigate().back();

        Element(Google.RESULT_LINK).at(10).click();
        Test().sleep(5);
        getDriver().navigate().back();

        Element(Google.RESULT_LINK).click();
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

        final int numberOfResults = Element(Rozetka.RESULT_LINK).getCount();

        LogUtil.log("Total results: " + numberOfResults);

        int randomProduct = Generate.integer(1, 5);
        LogUtil.log("" + randomProduct);
        String firstProduct = Element(Rozetka.RESULT_LINK).at(randomProduct).getText();
        int firstProductPrice = Element(Rozetka.RESULT_PRODUCT_PRICE).at(randomProduct).getNumber();
        LogUtil.log(firstProduct);
        LogUtil.log(String.valueOf(firstProductPrice));

        resultPage.addProductToCart(randomProduct).closeCart();

        randomProduct = Generate.integer(6, 17);
        LogUtil.log("" + (randomProduct - 1));
        String secondProduct = Element(Rozetka.RESULT_LINK).at(randomProduct).getText();
        int secondProductPrice = Element(Rozetka.RESULT_PRODUCT_PRICE).at(randomProduct).getNumber();
        LogUtil.log(secondProduct);
        LogUtil.log(String.valueOf(secondProductPrice));

        resultPage.addProductToCart(randomProduct - 1);

        int totalPrice = Element(Rozetka.CART_TOTAL_COST).getNumber();

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

        Verify(Page().hasText("sdfsdf")).withScreenshot().withMessage("test verify message").isTrue();


        /*Element(Rozetka.PC_SIDE_MENU, Rozetka.EBOOK_SUB_MENU).mouseOverAndClick();
        Element(Rozetka.MANUFECTURER).at("PocketBook").click();

        assertThat(Element(Rozetka.ACTIVE_FILTER).at("PocketBook").isDisplayed())
                .as("Manufacturer filter is displayed");


        int filteredProductsCount = Element(Rozetka.PRODUCT_NAME).getCount();

        for (int index = 1; index <= filteredProductsCount; index++) {
            String productName = Element(Rozetka.PRODUCT_NAME).at(index).getText();

            assertThat(productName)
                    .as("Filtered products contain manufacturer name")
                    .contains("PocketBook");
        }

        Element(Rozetka.MAX_PRICE_FILTER).type(String.valueOf(maxRange));
        Element(Rozetka.MAX_PRICE_FILTER).submit();

        assertThat(Element(Rozetka.ACTIVE_FILTER).at(maxRange).isDisplayed())
                .as("Price filter is displayed");

        filteredProductsCount = Element(Rozetka.PRODUCT_NAME).getCount();

        for (int index = 1; index <= filteredProductsCount; index++) {
            int productPrice = Element(Rozetka.PRODUCT_PRICE).at(index).getNumber();

            assertThat(productPrice)
                    .as("Product price filter is applied")
                    .isBetween(1, maxRange);
        }

        Page().takeScreenshot();

        Element(Rozetka.ACTIVE_FILTER).at("PocketBook").click();
        Element(Rozetka.ACTIVE_FILTER).at(String.valueOf(maxRange)).click();

        Page().takeScreenshot();*/

    }


}
