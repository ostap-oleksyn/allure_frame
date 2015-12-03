package actions;


import org.openqa.selenium.WebDriver;
import runner.TestRunner;
import utils.LogUtil;

import java.lang.reflect.Field;

public class Verify {

    private WebDriver driver;
    private boolean condition;
    private boolean takeScreenshot;
    private String message;


    public Verify(boolean condition, WebDriver driver) {
        this.driver = driver;
        this.condition = condition;
    }

    public Verify withScreenshot(){
        this.takeScreenshot = true;
        return this;
    }

    public Verify withMessage(final String message){
        this.message = message;
        return this;
    }

    public void isTrue() {
        if (!condition){
            Field f = null;
            try {
                f = TestRunner.class.getDeclaredField("result");
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
            f.setAccessible(true);
            try {
                f.set(null, "fail");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        if (message != null){
            LogUtil.log("Verify: " + message );
        }

        if (takeScreenshot){
            new PageActionImpl(driver).takeScreenshot();
        }
    }

    public void isfalse() throws NoSuchFieldException, IllegalAccessException {
        if (condition){
            Field f = TestRunner.class.getDeclaredField("result");
            f.setAccessible(true);
            f.set(null, "fail");
        }
        if (message != null){
            LogUtil.log("Verify: " + message );
        }

        if (takeScreenshot){
            new PageActionImpl(driver).takeScreenshot();
        }
    }
}
