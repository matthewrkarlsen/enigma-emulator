package me.matthewrkarlsen.enigma.setup;

import java.util.Properties;

public class EnigmaConfig {

    private final Properties properties;

    public EnigmaConfig(Properties properties) {
        this.properties = properties;
    }

    public boolean getBoolean(String reference) {
        return Boolean.parseBoolean(properties.getProperty(reference));
    }

    public String getString(String reference) {
        return properties.getProperty(reference);
    }

    public int getInt(String reference) {
        return Integer.parseInt(properties.getProperty(reference));
    }
}
