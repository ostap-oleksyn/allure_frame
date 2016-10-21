package utils;


import java.util.Random;

public class Generate {

    private Generate() {
    }

    public static String string(int length) {
        String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        Random rnd = new Random();

        StringBuilder text = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            text.append(chars.charAt(rnd.nextInt(chars.length())));
        }
        return text.toString();
    }

    public static int integer(int max) {
        Random random = new Random();
        return random.nextInt(max) + 1;
    }

    public static int integer(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }

    public static String loremIpsum(int numberOfWords) {
        String LOREM_IPSUM = "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, " +
                "sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. " +
                "At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus " +
                "est Lorem ipsum dolor sit amet. ";

        StringBuilder chars = new StringBuilder(LOREM_IPSUM);

        while (numberOfWords > chars.length()) {
            chars.append(chars);
        }

        return chars.substring(0, numberOfWords);
    }
}
