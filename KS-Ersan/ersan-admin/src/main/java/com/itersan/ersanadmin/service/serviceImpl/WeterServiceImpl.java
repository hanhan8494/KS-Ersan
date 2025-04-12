package com.itersan.ersanadmin.service.serviceImpl;

import com.itersan.ersanadmin.service.WeterService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@Service
public class WeterServiceImpl implements WeterService {


    @Override
    public Mono<String> getWeter(String wter) {

        WebClient webClient = WebClient.create();
        Map<String,String> map = new HashMap<>();
        map.put("area",wter);
        Mono<String> stringMono = webClient.get()
                .uri("https://ali-weather.showapi.com/area-to-id?area={area}", map)
                .accept(MediaType.APPLICATION_JSON)
                .header("Authorization", "APPCODE f532d161064d4386be8d25e4557dd618")
                .retrieve()
                .bodyToMono(String.class);



        return  stringMono;
    }
}
