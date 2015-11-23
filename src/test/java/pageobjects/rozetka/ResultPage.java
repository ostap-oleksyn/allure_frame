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
        Action(Rozetka.ADD_TO_CART_BUTTON).at(numberOfProduct).click();
        return this;
    }

    @Step("Close cart")
    public ResultPage closeCart(){
        Action(Rozetka.CLOSE_CART).click();
        return this;
    }

    @Step("Remove product")
    public ResultPage removeProduct(){
        Action(Rozetka.REMOVE_ITEM).click();
        Action(Rozetka.CONFIRM_REMOVE).click();
        return this;
    }

    @Step("Logging out")
    public void logOut(){
        Action(Rozetka.PERSONAL_LINK, Rozetka.LOGOUT_LINK).mouseOverAndClick();
    }

}
