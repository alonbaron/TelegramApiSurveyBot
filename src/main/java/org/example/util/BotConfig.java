package org.example.util;

public class BotConfig {
    public static final String TELEGRAM_BOT_TOKEN = requiredEnv("TELEGRAM_BOT_TOKEN");
    public static final String TELEGRAM_BOT_USERNAME = requiredEnv("TELEGRAM_BOT_USERNAME");
    public static final long ADMIN_TELEGRAM_ID = requiredLongEnv("ADMIN_TELEGRAM_ID");
    public static final boolean DEV_MODE = Boolean.parseBoolean(envOrDefault("DEV_MODE", "false"));
    public static final int MIN_MEMBERS = DEV_MODE ? 1 : 3;

    private BotConfig() {
    }

    private static String requiredEnv(String name) {
        String value = System.getenv(name);
        if (value == null || value.isBlank()) {
            throw new IllegalStateException("Missing required environment variable: " + name);
        }
        return value.trim();
    }

    private static long requiredLongEnv(String name) {
        String value = requiredEnv(name);
        try {
            return Long.parseLong(value);
        } catch (NumberFormatException e) {
            throw new IllegalStateException("Environment variable " + name + " must be a number", e);
        }
    }

    private static String envOrDefault(String name, String fallback) {
        String value = System.getenv(name);
        return value == null || value.isBlank() ? fallback : value.trim();
    }
}
