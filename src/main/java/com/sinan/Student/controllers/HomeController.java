package com.sinan.Student.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HomeController {

    @Value("${spring.application.name}")
    private String appName;

    @Value("${app.version}")
    private String appVersion;

    @GetMapping("/health")
    public Map health () {
        Map map = new HashMap<String,String>();
        map.put("app-name", appName);
        map.put("app-version", appVersion);
        map.put("status", "OK");
        return map;
    }
}
