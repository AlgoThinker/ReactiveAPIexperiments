package com.webfluxpoc.callerservice.serviceImpl;

import com.webfluxpoc.callerservice.service.AggregatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AggregatorServiceImpl implements AggregatorService {

    @Autowired
    DataHelper dataHelper;

    @Override
    public Mono<Integer> fetchSumOfValues(){
        Flux<Integer> fluxInt = dataHelper.fetchIntgersFromService();
        Flux<Character> fluxChar = dataHelper.fetchCharsFromService1();
        return Mono.zip(fluxChar.reduce(0, Integer::sum),
                fluxInt.reduce(0,Integer::sum),Integer::sum);
    }


}
