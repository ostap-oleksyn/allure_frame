package utils;


import java.util.Random;

public final class Generate {

    private Generate() {
    }

    public static String string(final int length) {
        final String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        final Random rnd = new Random();

        final StringBuilder text = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            text.append(chars.charAt(rnd.nextInt(chars.length())));
        }
        return text.toString();
    }

    public static int integer(final int max) {
        final Random random = new Random();
        return random.nextInt(max) + 1;
    }

    public static int integer(final int min, final int max) {
        final Random random = new Random();
        return random.nextInt(max) + min;
    }

    public static String loremIpsum(final int numberOfWords) {
        final String LOREM_IPSUM = "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, " +
                "sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. " +
                "At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus " +
                "est Lorem ipsum dolor sit amet. ";

        final StringBuilder chars = new StringBuilder(LOREM_IPSUM);

        while (numberOfWords > chars.length()) {
            chars.append(chars);
        }

        return chars.substring(0, numberOfWords);
    }
}
