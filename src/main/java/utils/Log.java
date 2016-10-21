package utils;


import ru.yandex.qatools.allure.annotations.Step;

public class Log {

    private Log() {
    }

    @Step("{0}")
    public static void info(String message){
        //intentionally empty
    }

}
