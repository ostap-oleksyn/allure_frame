package utils;


import org.testng.SkipException;

public final class TestUtil {

    private TestUtil() {
    }

    public static void skip(final String message) {
        throw new SkipException(message);
    }

    public static void sleep(final int seconds) {
        LogUtil.log("TEST: Sleep for " + seconds + " second");
        TimerImpl.sleep((long) (seconds * 1000));
    }

    public static void sleep(final long milliseconds) {
        TimerImpl.sleep(milliseconds);
    }

    public static void timer(final int seconds) {
        new TimerImpl(true, seconds);
    }

    public static boolean timerCheck() {
        if (TimerImpl.timerDuration != 0 && TimerImpl.running) {
            return TimerImpl.getElapsedSeconds() <= TimerImpl.timerDuration;
        } else {
            throw new IllegalStateException("Timer has not been set. See TestUtil().timer()");
        }
    }

    public static String timerTimestamp() {
        if (TimerImpl.running) {
            return TimerImpl.getElapsedFormatHHMMSS();
        } else {
            throw new IllegalStateException("Timer has not been set. See TestUtil().timer()");
        }
    }
}
