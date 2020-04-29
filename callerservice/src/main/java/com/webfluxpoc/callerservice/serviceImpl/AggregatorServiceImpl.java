package com.webfluxpoc.callerservice.serviceImpl;

import com.webfluxpoc.callerservice.service.AggregatorService;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Service
public class AggregatorServiceImpl implements AggregatorService {

    @Override
    public Flux<Integer> fetchIntgersFromService() {
        WebClient webClient = WebClient.create("http://localhost:8080");
        return webClient.get().uri("/fluxstream").
                retrieve().bodyToFlux(Integer.class).log("Items in api service");
    }

    @Override
    public Flux<Integer> fetchIntgersFromService1() {
        WebClient webClient1 = WebClient.create("http://localhost:8081");
        return webClient1.get().uri("/fluxstream1").
                retrieve().bodyToFlux(Integer.class).log("Items in api service 1");
    }
}
