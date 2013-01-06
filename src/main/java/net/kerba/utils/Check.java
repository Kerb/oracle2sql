package net.kerba.utils;

/**
 * Created by IntelliJ IDEA.
 * User: kerb
 * Date: 06.01.13
 * Time: 20:16
 */
public class Check {
    private Check() {
    }

    public static void notNull(Object o, String variableName) {
        if (o == null) {
            throw new IllegalArgumentException(String.format("'%s' must not be null",variableName));
        }
    }
}
