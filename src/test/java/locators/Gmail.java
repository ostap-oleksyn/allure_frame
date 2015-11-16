package locators;


import ui.ILocator;
import ui.LocatorType;

public enum Gmail implements ILocator {

    MAIL_FIELD("Mail field",
            LocatorType.BY_ID,
            "Email"),
    PASSWORD_FIELD("Password field",
            LocatorType.BY_ID,
            "Passwd"),
    NEXT_BUTTON("Next button",
            LocatorType.BY_ID,
            "next"),
    SUBMIT_BUTTON("Submit button",
            LocatorType.BY_ID,
            "signIn"),
    EMAIL_DISPLAY("Email display",
            LocatorType.BY_ID,
            "email-display"),
    SEARCH_FIELD("Serch field",
            LocatorType.BY_ID,
            "gbqfq"),
    LETTERS_OVERALL("Letters overall number",
            LocatorType.BY_XPATH,
            ".//*[@id=':hz']/span/b[3]"),
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


    Gmail(final String name, final LocatorType locatorType, final String rawLocator) {
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
