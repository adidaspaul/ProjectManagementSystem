package ua.goit.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Properties;

public class PropertiesUtil {
    Properties properties = null;

    public PropertiesUtil(){
        load();
    }
    public String getHostname() {
        return properties.getProperty("database.hostname");
    }

    public Integer getPort() {

        return Integer.parseInt(properties.getProperty("database.port"));
    }

    public String getSchema() {

        return properties.getProperty("database.schema");
    }

    public String getUser() {

        return properties.getProperty("database.user");
    }

    public String getPassword() {

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
