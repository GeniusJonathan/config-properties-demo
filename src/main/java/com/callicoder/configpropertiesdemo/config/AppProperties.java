package com.callicoder.configpropertiesdemo.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.convert.DurationUnit;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ConfigurationProperties(prefix="app")
@Validated
@Getter
@Setter
public class AppProperties {
    @NotNull
    private String name;
    private String description;
    private String uploadDir;
    private Duration connectTimeout = Duration.ofMillis(1000);
    @DurationUnit(ChronoUnit.SECONDS)
    private Duration readTimeout = Duration.ofSeconds(30);
    @Valid
    private Security security = new Security();

    @Getter
    @Setter
    public static class Security {
        private String username;
        private String password;
        @NotEmpty
        private List<String> roles = new ArrayList<>();
        private boolean enabled;
        private Map<String, String> permissions = new HashMap<>();
    }
}
