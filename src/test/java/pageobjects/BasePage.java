package pageobjects;


import action.Action;
import org.openqa.selenium.WebDriver;

public class BasePage {

    protected WebDriver driver;
    protected Action action;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.action = new Action(this.driver);
    }

}
