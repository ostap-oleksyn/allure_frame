package locators;


import org.openqa.selenium.By;
import ui.ILocator;
import ui.LocatorType;

public enum Google implements ILocator {

    SEARCH_FIELD("Search field",
            LocatorType.BY_XPATH,
            ".//*[@id='lst-ib']"),
    SEARCH_BUTTON("Search button",
            LocatorType.BY_XPATH,
            ".//*[@class='lsb']"),
    IMAGES_TAB("Images tab",
            LocatorType.BY_XPATH,
            ".//*[@id='hdtb-msb']/div[2]/a"),
    IMAGE("Image",
            LocatorType.BY_XPATH,
            ".//*[@id='rg_s']//img"),
    GOOGLE_LOGO("Logo",
            LocatorType.BY_XPATH,
            ".//*[@id='resultStats']"),
    RESULT_LINK("Result link",
            LocatorType.BY_XPATH,
            "(.//*[@class='r']//a)[%s]"),
    ACCOUNT_MENU("Account Menu",
            LocatorType.BY_XPATH,
            ".//*[@id='nav-link-yourAccount']"),
    START_HERE("Start Here",
            LocatorType.BY_XPATH,
            ".//*[@id='nav-flyout-ya-newCust']/a"),
    SELECT("SELECT",
            LocatorType.BY_XPATH,
            ".//select[@name='mydropdown']//option[@value='%s']");

    private String name;
    private LocatorType locatorType;
    private String rawLocator;
    private String modifiedLocator;
    private String position;

    Google(final String name, final LocatorType locatorType, final String rawLocator) {
        this.name = name;
        this.locatorType = locatorType;
        this.rawLocator = rawLocator;
    }

    public Google at(final int position) {
        this.position = String.valueOf(position);
        this.modifiedLocator = String.format(this.rawLocator, position);
        return this;
    }

    public Google at(final String position) {
        this.position = position;
        this.modifiedLocator = String.format(this.rawLocator, position);
        return this;
    }

    public By get() {
        By locator;
        if (this.modifiedLocator == null) {
            if (rawLocator.contains("%s")) {
                rawLocator = rawLocator.replace("%s", ".");
            }
            locator = this.locatorType.getBy(this.rawLocator);
        } else {
            locator = this.locatorType.getBy(this.modifiedLocator);
        }
        return locator;
    }

    @Override
    public String toString() {
        String logMessage;
        if (modifiedLocator == null) {
            logMessage = String.format("[%s > %s]", this.getClass().getSimpleName(), this.name);
        } else if (modifiedLocator.contains("[.]")){
            logMessage = String.format("[%s > %s] at position [1]", this.getClass().getSimpleName(), this.name);
        } else {
            logMessage = String.format("[%s > %s] at position [%s]", this.getClass().getSimpleName(), this.name, this.position);
        }
        return logMessage;
    }
}
