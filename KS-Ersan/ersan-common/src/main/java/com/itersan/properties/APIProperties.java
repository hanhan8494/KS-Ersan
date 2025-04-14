package com.itersan.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

//地名查询code
@Component
@ConfigurationProperties(prefix = "sky.weather")
@Data
public class APIProperties {

    private String appcode;
}
