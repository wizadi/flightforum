package ro.wizadi.flightforum.container.configuration.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import ro.wizadi.flightforum.container.configuration.DTOs.DB;

@Component
@ConfigurationProperties("core.app")
public class AppConfiguration {

    private String name;
    private String version;
    private DB db;

    public DB getDb() {
        return db;
    }

    public void setDb(DB db) {
        this.db = db;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
