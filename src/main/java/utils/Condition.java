package utils;


import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.function.Function;

public enum Condition {
    ELEMENT_IS_INVISIBLE(
            ExpectedConditions::invisibilityOfElementLocated,
            "Waiting for invisibility of "
    ),

    ELEMENT_IS_VISIBLE(
            ExpectedConditions::visibilityOfElementLocated,
            "Waiting for visibility of "
    ),
    ELEMENT_IS_CLICKABLE(
            ExpectedConditions::elementToBeClickable,
            "Waiting for element to be clickable "
    ),
    ELEMENT_IS_PRESENT(
            ExpectedConditions::presenceOfElementLocated,
            "Waiting for presence of "
    ),
    ELEMENT_IS_SELECTABLE(
            ExpectedConditions::elementToBeSelected,
            "Waiting for element to be selectable  "
    );

    private String message;
    private Function<By, ExpectedCondition<?>> condition;

    Condition(final Function<By, ExpectedCondition<?>> condition, final String message) {
        this.condition = condition;
        this.message = message;
    }

    @Override
    public String toString() {
        return this.message;
    }

    public Function<By, ExpectedCondition<?>> getCondition() {
        return condition;
    }
}
