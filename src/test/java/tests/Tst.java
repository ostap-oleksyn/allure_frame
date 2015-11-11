package tests;


import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

import static org.assertj.core.api.Assertions.*;
public class Tst {

    public static void main(String[] args) {
      String psass = "password";

        if (psass.matches("password")){
            System.out.println("YES");
        }

    }
}
