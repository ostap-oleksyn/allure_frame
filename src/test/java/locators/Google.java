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
    START_HERE("Start Here",
            LocatorType.BY_XPATH,
            ".//*[@id='nav-flyout-ya-newCust']/a"),
    SELECT("SELECT",
            LocatorType.BY_XPATH,
            ".//select[@name='mydropdown']//option[@value='%s']");

    private String name;
    private LocatorType locatorType;
    private String rawLocator;
    private String position;

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

    public String getPosition() {
        return position;
    }

    public void resetPosition() {
        this.position = null;
    }

    public Google at(final int position) {
        verify();
        this.position = String.valueOf(position);
        return this;

    }

    public Google at(final String position) {
        verify();
        this.position = String.valueOf(position);
        return this;

    }

    private void verify() {
        if (!this.rawLocator.contains("%s")) {
            throw new IllegalStateException(String.format("Locator [%s > %s] doesn't have a modifier: %s",
                    this.getClass().getSimpleName(), name, rawLocator));
        }
    }

}
