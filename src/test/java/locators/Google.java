package locators;


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
    AMAZON_CLICK("Amazon click",
            LocatorType.BY_XPATH,
            ".//*[@id='nav-flyout-shopAll']/div[2]/a/span"),
    AMAZON_OVER("Amazon over",
            LocatorType.BY_XPATH,
            ".//*[@id='nav-link-shopall']/span[2]");

    private String name;
    private LocatorType locatorType;
    private String rawLocator;

    Google(final String name, final LocatorType locatorType, final String rawLocator) {
        this.name = name;
        this.locatorType = locatorType;
        this.rawLocator = rawLocator;
    }

    public String getName() {
        return name;
    }

    public LocatorType getLocatorType() {
        return locatorType;
    }

    public String getRawLocator() {
        return rawLocator;
    }

}
