package action;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ui.ILocator;
import ui.LocatorImpl;

import java.util.List;

public final class Action {

    final private WebDriver driver;

    public Action(final WebDriver driver) {
        this.driver = driver;
    }

    public ActionImpl get(final ILocator locator) {
        return new ActionImpl(new LocatorImpl(locator), driver);
    }

    public void mouseOverAndClick(final ILocator overLocator, final ILocator clickLocator) {
        new ActionImpl(new LocatorImpl(overLocator), this.driver, new LocatorImpl(clickLocator)).mouseOverAndClick();
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public void navigate(final String url) {
        new LogActions(this.driver).navigate(url);
    }

    public List<WebElement> getList(final ILocator locator) {
        return new ActionImpl(new LocatorImpl(locator), this.driver).getList();
    }

    public void takeScreenshot() {
        new LogActions(this.driver).takeScreenshot();
    }
}
