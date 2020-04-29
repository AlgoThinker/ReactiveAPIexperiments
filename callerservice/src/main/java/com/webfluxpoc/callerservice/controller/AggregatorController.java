package com.webfluxpoc.callerservice.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.awt.*;
import java.util.stream.Collectors;

@RestController
public class AggregatorController {

    @GetMapping(value = "/client/retrieve", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Mono<Integer> getItems() {
        Flux<Integer> flux = Flux.merge(fetchIntgersFromService(), fetchIntgersFromService1());
        Mono<Integer> mono = flux.reduce(0, (a, b) -> a + b);
        return mono;
    }

    public Flux<Integer> fetchIntgersFromService() {
        WebClient webClient = WebClient.create("http://localhost:8080");
        return webClient.get().uri("/fluxstream").
                retrieve().bodyToFlux(Integer.class).log("Items in api service");
    }

    public Flux<Integer> fetchIntgersFromService1() {
        WebClient webClient1 = WebClient.create("http://localhost:8081");
        return webClient1.get().uri("/fluxstream1").
                retrieve().bodyToFlux(Integer.class).log("Items in api service 1");
    }


}
