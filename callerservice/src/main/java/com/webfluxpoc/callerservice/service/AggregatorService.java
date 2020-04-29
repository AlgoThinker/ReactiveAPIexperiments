package com.webfluxpoc.callerservice.service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

public interface AggregatorService {

     Flux<Integer> fetchIntgersFromService();
     Flux<Integer> fetchIntgersFromService1();

}
