package pageobjects.rozetka;


import locators.Rozetka;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;

public class ResultPage extends BasePage {
    public ResultPage(WebDriver driver) {
        super(driver);
    }

    @Step("Add product to cart")
    public ResultPage addProductToCart(int numberOfProduct){
        element(Rozetka.ADD_TO_CART_BUTTON).at(numberOfProduct).click();
        return this;
    }

    @Step("Close cart")
    public ResultPage closeCart(){
        element(Rozetka.CLOSE_CART).click();
        return this;
    }

    @Step("Remove product")
    public ResultPage removeProduct(){
        element(Rozetka.REMOVE_ITEM).click();
        element(Rozetka.CONFIRM_REMOVE).click();
        return this;
    }

    @Step("Logging out")
    public void logOut(){
        element(Rozetka.PERSONAL_LINK).hover();
        element(Rozetka.LOGOUT_LINK).click();
    }

}
