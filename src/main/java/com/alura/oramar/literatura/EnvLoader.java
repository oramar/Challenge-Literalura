package com.alura.oramar.literatura;

import io.github.cdimascio.dotenv.Dotenv;

public class EnvLoader {

    public static void loadEnv() {

        Dotenv dotenv = Dotenv.configure()
                .ignoreIfMissing()
                .load();

        setProperty("DB_NAME", dotenv);
        setProperty("DB_USER", dotenv);
        setProperty("DB_PASSWORD", dotenv);
    }

    private static void setProperty(String key, Dotenv dotenv) {
        String value = dotenv.get(key);
        if (value != null) {
            System.setProperty(key, value);
        }
    }
}