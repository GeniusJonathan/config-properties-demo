package com.callicoder.configpropertiesdemo.controller;

import com.callicoder.configpropertiesdemo.config.AppProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class IndexController {

    // Injecting ConfigurationProperties in your beans
    @Autowired
    private AppProperties appProperties;

    @GetMapping("/")
    public Map<String, String> getAppDetails() {
        Map<String, String> appDetails = new HashMap<>();
        appDetails.put("name", appProperties.getName());
        appDetails.put("description", appProperties.getDescription());
        appDetails.put("username", appProperties.getSecurity().getUsername());
        appDetails.put("password", appProperties.getSecurity().getPassword());
        return appDetails;
    }
}
