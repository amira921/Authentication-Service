package com.microservices.authentication.config;

import com.microservices.authentication.logger.AuthLogger;
import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import java.util.Map;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "")
public class AppPropertiesConfig {
    private Map<String, String> properties;

    public void logProperties() {
        AuthLogger.logInfo("==== Loaded Application Properties ====");
        properties.forEach((key, value) -> AuthLogger.logInfo("{} = {}", key, value));
        AuthLogger.logInfo("=======================================");
    }
}

