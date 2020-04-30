package com.webfluxpoc.callerservice.service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AggregatorService {

    Mono<Integer> fetchSumOfValues();

}
