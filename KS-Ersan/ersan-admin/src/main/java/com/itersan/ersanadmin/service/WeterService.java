package com.itersan.ersanadmin.service;

import reactor.core.publisher.Mono;

public interface WeterService {
    Mono<String> getWeter(String wter);
}
