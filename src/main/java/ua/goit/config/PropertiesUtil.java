package ua.goit.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Properties;

public class PropertiesUtil {
    Properties properties = null;

    public String getHostname() {
        if (Objects.isNull(properties)) {
            load();
        }
        return properties.getProperty("database.hostname");
    }

    public Integer getPort() {
        if (Objects.isNull(properties)) {
            load();
        }
        return Integer.parseInt(properties.getProperty("database.port"));
    }

    public String getSchema() {
        if (Objects.isNull(properties)) {
            load();
        }
        return properties.getProperty("database.schema");
    }

    public String getUser() {
        if (Objects.isNull(properties)) {
            load();
        }
        return properties.getProperty("database.user");
    }

    public String getPassword() {
        if (Objects.isNull(properties)) {
            load();
        }
        return properties.getProperty("database.password");
    }

    public void load() {
        this.properties = new Properties();
        try (InputStream is = ClassLoader.getSystemResourceAsStream("application.properties")) {
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
