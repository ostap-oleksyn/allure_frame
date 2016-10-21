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
        Element(Rozetka.ADD_TO_CART_BUTTON).at(numberOfProduct).click();
        return this;
    }

    @Step("Close cart")
    public ResultPage closeCart(){
        Element(Rozetka.CLOSE_CART).click();
        return this;
    }

    @Step("Remove product")
    public ResultPage removeProduct(){
        Element(Rozetka.REMOVE_ITEM).click();
        Element(Rozetka.CONFIRM_REMOVE).click();
        return this;
    }

    @Step("Logging out")
    public void logOut(){
        Element(Rozetka.PERSONAL_LINK).hover();
        Element(Rozetka.LOGOUT_LINK).click();
    }

}
