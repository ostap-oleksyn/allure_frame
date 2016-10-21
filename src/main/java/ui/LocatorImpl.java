package ui;


import org.openqa.selenium.By;


public class LocatorImpl {

    private ILocator locator;
    private LocatorType locatorType;
    private String position;
    private String rawLocator;
    private String modifiedLocator;


    public LocatorImpl(ILocator locator, String position) {
        this.locator = locator;
        this.position = position;
        this.rawLocator = locator.getRawLocator();
        verifyModifier();
        this.locatorType = locator.getLocatorType();
        modify();
    }

    private void verifyModifier() {
        if (position != null && !this.rawLocator.contains("%s")) {
            throw new IllegalArgumentException(String.format("Locator [%s > %s] doesn't have a '%%s' modifier: %s",
                    locator.getClass().getSimpleName(), locator.getName(), rawLocator));
        }
    }

    private void modify() {
        if (position == null && this.rawLocator.contains("%s")) {
            this.rawLocator = this.rawLocator.replace("%s", ".");
        } else if (position != null && this.rawLocator.contains("%s")) {
            this.modifiedLocator = String.format(this.rawLocator, position);
        }
    }

    public By get() {
        By locator;
        if (this.modifiedLocator == null) {
            locator = this.locatorType.getBy(this.rawLocator);
        } else {
            locator = this.locatorType.getBy(this.modifiedLocator);
        }
        return locator;
    }

    @Override
    public String toString() {
        String logMessage;
        if (modifiedLocator == null && !rawLocator.contains("[.]")) {
            logMessage = String.format("[%s > %s]", locator.getClass().getSimpleName(), locator.getName());
        } else if (this.position == null && rawLocator.contains("[.]")) {
            logMessage = String.format("[%s > %s] at position [1]", locator.getClass().getSimpleName(), locator.getName());
        } else {
            logMessage = String.format("[%s > %s] at position [%s]", locator.getClass().getSimpleName(), locator.getName(), this.position);
        }
        return logMessage;
    }
}
