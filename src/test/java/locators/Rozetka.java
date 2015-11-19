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
    LETTERS_TABLE_ROW("Letters table row",
            LocatorType.BY_XPATH,
            ".//tr[@class='zA yO'][%s]"),
    LETTERS_TABLE_SUBJECT("Letters table row",
            LocatorType.BY_XPATH,
            "(.//tr[@class='zA yO']//td[6]//span[1])[%s]"),
    NEW_LETTER_BUTTON("New leter button",
            LocatorType.BY_XPATH,
            ".//*[@id=':i5']/div/div"),
    RECIEVER_FIELD("Reciever field",
            LocatorType.BY_XPATH,
            ".//*[@id=':pb']"),
    SUBJECT_FIELD("Subject field",
            LocatorType.BY_XPATH,
            ".//*[@id=':ow']"),
    LETTER_CONTENT("Letter Content",
            LocatorType.BY_XPATH,
            ".//*[@id=':py']"),
    SEND_BUTTON("Send Button",
            LocatorType.BY_XPATH,
            ".//*[@id=':om']"),
    REFRESH_BUTTON("Refresh Button",
            LocatorType.BY_XPATH,
            "(.//*[@class='asa'])[6]"),

    ;

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
