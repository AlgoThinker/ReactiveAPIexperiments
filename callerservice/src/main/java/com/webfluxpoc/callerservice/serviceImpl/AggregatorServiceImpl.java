package com.webfluxpoc.callerservice.serviceImpl;

import com.webfluxpoc.callerservice.service.AggregatorService;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AggregatorServiceImpl implements AggregatorService {

    @Override
    public Mono<Integer> fetchSumOfValues(){
        Flux<Integer> fluxInt = fetchIntgersFromService();
        Flux<Character> fluxChar = fetchCharsFromService1();

        return Mono.zip(fluxChar.reduce(0, Integer::sum),fluxInt.reduce(0,Integer::sum),Integer::sum);
    }


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
