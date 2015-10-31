package utils;


import java.util.Date;

public class TimerImpl {

    private static Date t1;
    private static Date t2;
    public static boolean running = false;
    public static int timerDuration = 0;

    public TimerImpl() {
    }

    public TimerImpl(boolean start, int timerDuration) {
        if (start) {
            this.start(timerDuration);

        }

    }

    public void start(int timerDuration) {
        t1 = new Date();
        running = true;
        TimerImpl.timerDuration = timerDuration;
    }

    public static int getElapsedSeconds() {
        if (running) {
            t2 = new Date();
        }

        int elapsed = 0;
        if (t1 != null && t2 != null) {
            elapsed = (int) ((t2.getTime() - t1.getTime()) / 1000L);
        }

        return elapsed;
    }

    public static long getElapsedMilliseconds() {
        if (running) {
            t2 = new Date();
        }

        long elapsed = 0L;
        if (t1 != null && t2 != null) {
            elapsed = t2.getTime() - t1.getTime();
        }

        return elapsed;
    }

    public void stop() {
        t2 = new Date();
        running = false;
    }

    public static String getElapsedFormatHHMMSS() {
        long milliseconds = getElapsedMilliseconds();
        int hours = (int) (milliseconds / 1000L / 60L / 60L);
        int minutes = (int) (milliseconds / 1000L / 60L % 60L);
        int seconds = (int) (milliseconds / 1000L % 60L);
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

    public static void sleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException var3) {
            Thread.currentThread().interrupt();
        }

    }

    public static String getFormatHHMMSS(Date date) {
        long milliseconds = new Date().getTime() - date.getTime();
        int hours = (int) (milliseconds / 1000L / 60L / 60L);
        int minutes = (int) (milliseconds / 1000L / 60L % 60L);
        int seconds = (int) (milliseconds / 1000L % 60L);
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

    public static String getFormatHHMMSS(int seconds) {
        int hr = seconds / 60 / 60;
        int min = seconds / 60 % 60;
        int sec = seconds % 60;
        return String.format("%02d:%02d:%02d", hr, min, sec);
    }
}
