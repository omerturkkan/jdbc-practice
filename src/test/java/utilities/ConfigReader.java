package utilities;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class ConfigReader {

    private static final Properties PROPERTIES = new Properties();

    static {
        try (InputStream input = ConfigReader.class.getClassLoader()
                .getResourceAsStream("configuration.properties")) {
            PROPERTIES.load(input);
        } catch (IOException e) {
            throw new RuntimeException("configuration.properties could not be loaded", e);
        }
    }

    private ConfigReader() { }

    public static String getProperty(String key) {
        return PROPERTIES.getProperty(key);
    }
}