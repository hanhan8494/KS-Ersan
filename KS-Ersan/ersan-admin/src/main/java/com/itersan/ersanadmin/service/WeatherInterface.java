package com.itersan.ersanadmin.service;


import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import reactor.core.publisher.Mono;

//调用阿里云天气API接口:根据地名查询天气
public interface WeatherInterface {


    @GetExchange(url = "https://ali-weather.showapi.com/area-to-id", accept = "application/json")
    Mono<String> getWeather(@RequestParam("area") String area);
}
