package com.webfluxpoc.callerservice.controller;

import com.webfluxpoc.callerservice.serviceImpl.AggregatorServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@WebFluxTest(controllers = AggregatorController.class)
@Import(AggregatorServiceImpl.class)
@AutoConfigureWebTestClient(timeout = "10000")//10 seconds
class AggregatorControllerTest {

    @Autowired
    private WebTestClient webClient;

    @Test
    void getItems() {
        webClient.get().uri("/client/retrieve")
                .exchange()
                .expectStatus().isOk()
                .equals(36);
    }
}