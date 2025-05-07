package com.itersan.ersanadmin.controller;

import com.itersan.ersanadmin.service.WeatherInterface;
import com.itersan.properties.APIProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/wet")
@Slf4j
public class WetController {
    @Autowired
    APIProperties apiProperties;
    @Autowired
    WeatherInterface weatherInterface;

    @GetMapping("/san")
    public Mono<String> getadd(@RequestParam("area") String area) {
        log.info(apiProperties.getAppcode().toString());
        Mono<String> weather = weatherInterface.getWeather(area);
        return weather;
    }


}
