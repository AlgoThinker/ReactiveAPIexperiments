package com.webfluxpoc.callerservice.serviceImpl;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Component
public class DataHelper {

    Flux<Integer> fetchIntgersFromService() {
        WebClient webClient = WebClient.create("http://localhost:8080");
        return webClient.get().uri("/fluxstream").
                retrieve().bodyToFlux(Integer.class).log("Items in api service");
    }

    Flux<Character> fetchCharsFromService1() {
        WebClient webClient1 = WebClient.create("http://localhost:8081");
        return webClient1.get().uri("/fluxstream1").
                retrieve().bodyToFlux(Character.class).log("Items in api service 1");
    }
}
