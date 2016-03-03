package enums;


public enum Browsers {
    FIREFOX("FIREFOX"),
    CHROME("CHROME"),
    IE("IE");

    String browser;

    Browsers(String browser) {
        this.browser = browser;
    }
}
