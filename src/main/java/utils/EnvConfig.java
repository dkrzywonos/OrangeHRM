package utils;

import io.github.cdimascio.dotenv.Dotenv;

public class EnvConfig {
    private static final Dotenv dotenv = Dotenv.load();

    public static String getUsername() {
        return dotenv.get("TEST_USERNAME");
    }

    public static String getPassword() {
        return dotenv.get("TEST_PASSWORD");
    }
}
