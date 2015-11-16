package ui;


import org.openqa.selenium.By;


public class LocatorImpl {

    final private ILocator locator;
    final private LocatorType locatorType;
    private String position;
    private String rawLocator;
    private String modifiedLocator;


    public LocatorImpl(final ILocator locator) {
        this.locator = locator;
        this.locatorType = locator.getLocatorType();
        this.rawLocator = locator.getRawLocator();
        verify();
    }


    private void verify() {
        if (position == null) {
            this.modifiedLocator = null;
            if (this.rawLocator.contains("%s")) {
                this.rawLocator = this.rawLocator.replace("%s", ".");
            }
        } else {
            this.modifiedLocator = String.format(this.rawLocator, position);
        }
        locator.resetPosition();
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
