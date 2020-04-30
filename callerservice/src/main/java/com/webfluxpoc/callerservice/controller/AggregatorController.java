package com.webfluxpoc.callerservice.controller;

import com.webfluxpoc.callerservice.service.AggregatorService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    AggregatorService aggregatorService;

    @GetMapping("/client/retrieve")
    public Mono<Integer> getItems() {
        return aggregatorService.fetchSumOfValues();
    }
}
