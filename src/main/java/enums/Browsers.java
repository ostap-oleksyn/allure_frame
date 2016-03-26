package enums;


public enum Browsers {
    FIREFOX("FIREFOX"),
    CHROME("CHROME"),
    IE("IE");

    private String browser;

    Browsers(String browser) {
        this.browser = browser;
    }
}
