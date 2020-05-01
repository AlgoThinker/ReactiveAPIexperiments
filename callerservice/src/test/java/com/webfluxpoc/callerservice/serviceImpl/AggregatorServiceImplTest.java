package com.webfluxpoc.callerservice.serviceImpl;

import com.webfluxpoc.callerservice.service.AggregatorService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
//import org.junit.runner.Runwith;
import static org.mockito.Mockito.*;


//@RunWith(MockitoJUnitRunner.Silent.class)
@SpringBootTest
@ExtendWith(MockitoExtension.class)
class AggregatorServiceImplTest {

    @Autowired
    AggregatorService aggService;

    @Mock
    DataHelper dataHelper;

    @Test
    void fetchSumOfValues_Test() {
        lenient().when(dataHelper.fetchCharsFromService1())
                .thenReturn(Flux.just('a','b','c','d'));

        lenient().when(dataHelper.fetchIntgersFromService()).
                thenReturn(Flux.just(1,2,3,4));

        Mono<Integer> integerMono = aggService.fetchSumOfValues();
        StepVerifier.create(integerMono).
                expectNextMatches(val -> val == 404).verifyComplete();
    }
}