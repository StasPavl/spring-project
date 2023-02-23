package com.cydeo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component

@ConfigurationProperties(prefix = "db")
@Data

public class DBConfigData {

    private String username;
    private String password;
    private List<String> type;


}
