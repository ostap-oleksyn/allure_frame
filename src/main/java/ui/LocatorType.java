package ui;


import org.openqa.selenium.By;

public enum LocatorType {
    BY_CLASS_NAME {
        @Override
        public By getBy(final String locator) {
            return By.className(locator);
        }
    },
    BY_CSS_SELECTOR {
        @Override
        public By getBy(final String locator) {
            return By.cssSelector(locator);
        }
    },
    BY_ID {
        @Override
        public By getBy(final String locator) {
            return By.id(locator);
        }
    },
    BY_LINK_TEXT {
        @Override
        public By getBy(final String locator) {
            return By.linkText(locator);
        }
    },
    BY_NAME {
        @Override
        public By getBy(final String locator) {
            return By.name(locator);
        }
    },
    BY_TAG_NAME {
        @Override
        public By getBy(final String locator) {
            return By.tagName(locator);
        }
    },
    BY_XPATH {
        @Override
        public By getBy(final String locator) {
            return By.xpath(locator);
        }
    };

    public abstract By getBy(String locator);

}
