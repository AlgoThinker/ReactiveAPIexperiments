package com.webfluxpoc.callerservice.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.awt.*;

@RestController
public class AggregatorController {

    WebClient webClient = WebClient.create("http://localhost:8080");

    @GetMapping(value = "/client/retrieve", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<Integer> getItems(){
        return webClient.get().uri("/fluxstream").retrieve().bodyToFlux(Integer.class).log("Items in caller service");
    }
}
