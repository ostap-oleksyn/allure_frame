package utils;


import java.util.Date;

public final class TimerImpl {

    private static Date t1;
    private static Date t2;
    public static boolean running;
    public static int timerDuration;

    public TimerImpl() {
    }

    public TimerImpl(final boolean start, final int timerDuration) {
        if (start) {
            this.start(timerDuration);

        }

    }

    public void start(final int timerDuration) {
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
        final long milliseconds = getElapsedMilliseconds();
        final int hours = (int) (milliseconds / 1000L / 60L / 60L);
        final int minutes = (int) (milliseconds / 1000L / 60L % 60L);
        final int seconds = (int) (milliseconds / 1000L % 60L);
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

    public static void sleep(final long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException var3) {
            Thread.currentThread().interrupt();
        }

    }

    public static String getFormatHHMMSS(final Date date) {
        final long milliseconds = new Date().getTime() - date.getTime();
        final int hours = (int) (milliseconds / 1000L / 60L / 60L);
        final int minutes = (int) (milliseconds / 1000L / 60L % 60L);
        final int seconds = (int) (milliseconds / 1000L % 60L);
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

    public static String getFormatHHMMSS(final int seconds) {
        final int hr = seconds / 60 / 60;
        final int min = seconds / 60 % 60;
        final int sec = seconds % 60;
        return String.format("%02d:%02d:%02d", hr, min, sec);
    }
}
