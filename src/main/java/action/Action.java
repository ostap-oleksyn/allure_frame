package action;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ui.ILocator;

import java.util.List;

public class Action {

    private WebDriver driver;

    public Action(WebDriver driver) {
        this.driver = driver;
    }

    public ActionImpl get(ILocator locator) {
        return new ActionImpl(locator, driver);
    }

    public void mouseOverAndClick(ILocator overLocator, ILocator clickLocator) {
        new ActionImpl(overLocator, this.driver, clickLocator).mouseOverAndClick();
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public void navigate(String url) {
        new LogActions(this.driver).navigate(url);
    }

    public List<WebElement> getElements(ILocator locator) {
        return driver.findElements(locator.get());
    }

    public void takeScreenshot() {
        new LogActions(this.driver).takeScreenshot();
    }
}
