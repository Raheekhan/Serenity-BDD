package utils;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

public class TestUtils {

    public static String getRandomValue() {
        Random random = new Random();
        int randomInt = random.nextInt(1000);
        return Integer.toString(randomInt);
    }

    public static String getRandomString() {
        return RandomStringUtils.randomAlphabetic(4);
    }
}
