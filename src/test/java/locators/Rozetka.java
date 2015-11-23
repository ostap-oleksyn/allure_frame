package locators;


import ui.ILocator;
import ui.LocatorType;

public enum Rozetka implements ILocator {

    PERSONAL_LINK("Enter personal cabinet",
            LocatorType.BY_XPATH,
            ".//*[@id='header_user_menu_parent']/a"),
    LOGIN_FIELD("Login field",
            LocatorType.BY_XPATH,
            ".//*[@class='popup-css popup-auth']//input[@name='login']"),
    PASSWORD_FIELD("Password field",
            LocatorType.BY_XPATH,
            ".//*[@class='popup-css popup-auth']//input[@name='password']"),
    SEARCH_FIELD("Search field",
            LocatorType.BY_XPATH,
            ".//*[@id='search']/form/div[1]/div[2]/input"),
    LOGIN_BUTTON("Login button",
            LocatorType.BY_XPATH,
            ".//*[@class='popup-css popup-auth']//button"),
    RESULT_LINK("Result link",
            LocatorType.BY_XPATH,
            "(.//*[@class='g-i-list-title'])[%s]"),
    ADD_TO_CART_BUTTON("Add to cart button",
            LocatorType.BY_XPATH,
            "(.//*[@id='block_with_search']//button)[%s]"),
    CART("Cart",
            LocatorType.BY_XPATH,
            ".//*[@id='cart-popup']"),
    CART_TOTAL_COST("Cart total cost",
            LocatorType.BY_XPATH,
            ".//*[@name='cost']"),
    REMOVE_ITEM("Remove item",
            LocatorType.BY_XPATH,
            "(.//*[@class='cart-check']//img)[%s]"),
    CONFIRM_REMOVE("Confirm remove",
            LocatorType.BY_XPATH,
            ".//*[@class='cart-i-delete']//a[@name='delete']"),
    CLOSE_CART("Close cart",
            LocatorType.BY_XPATH,
            ".//*[@id='cart-popup']//*[@class='popup-close']//img"),
    PRODUCT_PRICE("Product price",
            LocatorType.BY_XPATH,
            "(.//*[@id='block_with_search']//div[@class='g-price-uah'])[%s]"),
    EMPTY_CART_BLOCK("Empty cart block",
            LocatorType.BY_XPATH,
            ".//*[@id='drop-block']"),
    PROCESS_BLOCK("Process block",
            LocatorType.BY_XPATH,
            ".//*[@class='process']"),
    LOGOUT_LINK("Logout link",
            LocatorType.BY_XPATH,
            ".//*[@id='header_user_menu']/li[10]/a");

    private String name;
    private LocatorType locatorType;
    private String rawLocator;


    Rozetka(final String name, final LocatorType locatorType, final String rawLocator) {
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
