package tests;


import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

import static org.assertj.core.api.Assertions.*;
public class Tst {

    public static void main(String[] args) {
        SoftAssertions soft = new SoftAssertions();
        soft.assertThat(2).isEqualTo(5).as("sdffdsfad");
        soft.assertThat(2).isEqualTo(5).withFailMessage("sdffdsfad");
        soft.assertThat(2).isEqualTo(5).overridingErrorMessage("sdffdsfad");
        soft.assertThat(2).as("1111111111").isEqualTo(5);
        soft.assertThat(2).withFailMessage("33333333333").isEqualTo(5);
        soft.assertThat(2).overridingErrorMessage("22222222222").isEqualTo(5);

        soft.assertAll();

    }
}
