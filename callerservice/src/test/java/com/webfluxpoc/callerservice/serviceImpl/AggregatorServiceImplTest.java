package com.webfluxpoc.callerservice.serviceImpl;

import com.webfluxpoc.callerservice.service.AggregatorService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AggregatorServiceImplTest {

    AggregatorServiceImpl aggServiceMock = mock(AggregatorServiceImpl.class);

    @Test
    void fetchSumOfValues_Test() {
        when(aggServiceMock.fetchSumOfValues())
                .thenReturn(Mono.just(404));
        Mono<Integer> integerMono = aggServiceMock.fetchSumOfValues();
        StepVerifier.create(integerMono).
                expectNextMatches(val -> val == 404).verifyComplete();
    }
    @Test
    void fetchIntgersFromService_Test() {
        when(aggServiceMock.fetchIntgersFromService()).
                thenReturn(Flux.just(1,2,3,4));
        Flux<Integer> integerFlux = aggServiceMock.fetchIntgersFromService();
        StepVerifier.create(integerFlux).expectNext(1,2,3,4).verifyComplete();
    }

    @Test
    void fetchCharsFromService1() {
        when(aggServiceMock.fetchCharsFromService1()).
                thenReturn(Flux.just('a','b','c','d'));
        Flux<Character> characterFlux = aggServiceMock.fetchCharsFromService1();
        StepVerifier.create(characterFlux).expectNext('a','b','c','d').verifyComplete();
    }
}