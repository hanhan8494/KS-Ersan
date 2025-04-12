package com.itersan.ersanadmin.controller;

import com.itersan.ersanadmin.service.WeterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class WterController {

    @Autowired
    private WeterService weterService;
    @GetMapping("/add")
    public Mono<String> WterController(@RequestParam("wter") String wter) {
        Mono<String> weter = weterService.getWeter(wter);
        return weter;
    }
}
