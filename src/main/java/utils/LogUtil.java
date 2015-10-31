package utils;


import ru.yandex.qatools.allure.annotations.Step;

public final class LogUtil {

    @Step("{0}")
    public static String log(final String message){
        return message;
    }

}
