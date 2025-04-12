package com.itersan.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "sky.webmvc")
@Data
public class WebMvcProperties {

    private String path;

}
