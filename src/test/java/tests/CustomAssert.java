package tests;


import org.assertj.core.api.*;
import org.assertj.core.description.Description;
import org.assertj.core.error.ErrorMessageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.Comparator;
import java.util.function.Predicate;

public class CustomAssert extends AbstractAssert<CustomAssert, Object> {

    public CustomAssert(Object object){
        super(object, CustomAssert.class);
    }

    public static CustomAssert assertThat(Object actual) {
        return new CustomAssert(actual);
    }

    @Step("FAIL: {0}")
    @Override
    protected void failWithMessage(String errorMessage, Object... arguments) {
        super.failWithMessage(errorMessage, arguments);
    }

    protected CustomAssert(Object actual, Class<?> selfType) {
        super(actual, selfType);
    }

    @Override
    protected WritableAssertionInfo getWritableAssertionInfo() {
        return super.getWritableAssertionInfo();
    }

    @Override
    protected void throwAssertionError(ErrorMessageFactory errorMessageFactory) {
        super.throwAssertionError(errorMessageFactory);
    }


    @Override
    public CustomAssert as(String description, Object... args) {
        return super.as(description, args);
    }

    @Override
    protected CustomAssert inHexadecimal() {
        return super.inHexadecimal();
    }

    @Override
    protected CustomAssert inBinary() {
        return super.inBinary();
    }

    @Override
    public CustomAssert describedAs(String description, Object... args) {
        return super.describedAs(description, args);
    }

    @Override
    public CustomAssert describedAs(Description description) {
        return super.describedAs(description);
    }

    @Override
    public CustomAssert isEqualTo(Object expected) {
        return super.isEqualTo(expected);
    }

    @Override
    public CustomAssert isNotEqualTo(Object other) {
        return super.isNotEqualTo(other);
    }

    @Override
    public void isNull() {
        super.isNull();
    }

    @Override
    public CustomAssert isNotNull() {
        return super.isNotNull();
    }

    @Override
    public CustomAssert isSameAs(Object expected) {
        return super.isSameAs(expected);
    }

    @Override
    public CustomAssert isNotSameAs(Object other) {
        return super.isNotSameAs(other);
    }

    @Override
    public CustomAssert isIn(Object... values) {
        return super.isIn(values);
    }

    @Override
    public CustomAssert isNotIn(Object... values) {
        return super.isNotIn(values);
    }

    @Override
    public CustomAssert isIn(Iterable<?> values) {
        return super.isIn(values);
    }

    @Override
    public CustomAssert isNotIn(Iterable<?> values) {
        return super.isNotIn(values);
    }

    @Override
    public CustomAssert is(Condition<? super Object> condition) {
        return super.is(condition);
    }

    @Override
    public CustomAssert isNot(Condition<? super Object> condition) {
        return super.isNot(condition);
    }

    @Override
    public CustomAssert has(Condition<? super Object> condition) {
        return super.has(condition);
    }

    @Override
    public CustomAssert doesNotHave(Condition<? super Object> condition) {
        return super.doesNotHave(condition);
    }

    @Override
    public CustomAssert isInstanceOf(Class<?> type) {
        return super.isInstanceOf(type);
    }

    @Override
    public CustomAssert isInstanceOfAny(Class<?>... types) {
        return super.isInstanceOfAny(types);
    }

    @Override
    public CustomAssert isNotInstanceOf(Class<?> type) {
        return super.isNotInstanceOf(type);
    }

    @Override
    public CustomAssert isNotInstanceOfAny(Class<?>... types) {
        return super.isNotInstanceOfAny(types);
    }

    @Override
    public CustomAssert hasSameClassAs(Object other) {
        return super.hasSameClassAs(other);
    }

    @Override
    public CustomAssert hasToString(String expectedToString) {
        return super.hasToString(expectedToString);
    }

    @Override
    public CustomAssert doesNotHaveSameClassAs(Object other) {
        return super.doesNotHaveSameClassAs(other);
    }

    @Override
    public CustomAssert isExactlyInstanceOf(Class<?> type) {
        return super.isExactlyInstanceOf(type);
    }

    @Override
    public CustomAssert isNotExactlyInstanceOf(Class<?> type) {
        return super.isNotExactlyInstanceOf(type);
    }

    @Override
    public CustomAssert isOfAnyClassIn(Class<?>... types) {
        return super.isOfAnyClassIn(types);
    }

    @Override
    public CustomAssert isNotOfAnyClassIn(Class<?>... types) {
        return super.isNotOfAnyClassIn(types);
    }

    @Override
    public AbstractListAssert<?, ?, Object> asList() {
        return super.asList();
    }

    @Override
    public AbstractCharSequenceAssert<?, String> asString() {
        return super.asString();
    }

    @Override
    public String descriptionText() {
        return super.descriptionText();
    }

    @Step("FAIL: {0}")
    @Override
    public CustomAssert overridingErrorMessage(String newErrorMessage, Object... args) {
        return super.overridingErrorMessage(newErrorMessage, args);
    }

    @Step("FAIL: {0}")
    @Override
    public CustomAssert withFailMessage(String newErrorMessage, Object... args) {
        return super.withFailMessage(newErrorMessage, args);
    }

    @Override
    public CustomAssert usingComparator(Comparator<? super Object> customComparator) {
        return super.usingComparator(customComparator);
    }

    @Override
    public CustomAssert usingDefaultComparator() {
        return super.usingDefaultComparator();
    }

    @Override
    public CustomAssert withThreadDumpOnError() {
        return super.withThreadDumpOnError();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public CustomAssert matches(Predicate<? super Object> predicate) {
        return super.matches(predicate);
    }

    @Override
    public CustomAssert matches(Predicate<? super Object> predicate, String predicateDescription) {
        return super.matches(predicate, predicateDescription);
    }
}
