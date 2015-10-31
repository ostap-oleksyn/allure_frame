package utils;


import org.testng.SkipException;

public final class TestUtil {

    public static void skip(String message) {
        throw new SkipException(message);
    }

    public static void sleep(int seconds) {
        TimerImpl.sleep((long) (seconds * 1000));
    }

    public static void sleep(long milliseconds) {
        TimerImpl.sleep(milliseconds);
    }

    public static void timer(int seconds) {
        new TimerImpl(true, seconds);
    }

    public static boolean timerCheck() {
        if(TimerImpl.timerDuration != 0 && TimerImpl.running) {
            return (TimerImpl.getElapsedSeconds() <= TimerImpl.timerDuration);
        } else {
            throw new IllegalStateException("Timer has not been set. See TestUtil().timer()");
        }
    }

    public static String timerTimestamp() {
        if(!TimerImpl.running) {
            throw new IllegalStateException("Timer has not been set. See TestUtil().timer()");
        } else {
            return TimerImpl.getElapsedFormatHHMMSS();
        }
    }
}
