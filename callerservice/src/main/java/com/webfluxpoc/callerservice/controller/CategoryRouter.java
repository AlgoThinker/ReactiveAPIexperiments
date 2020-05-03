package com.webfluxpoc.callerservice.controller;

import com.webfluxpoc.callerservice.model.Category;
import com.webfluxpoc.callerservice.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.http.ResponseEntity.ok;
import static org.springframework.web.reactive.function.BodyInserters.fromValue;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class CategoryRouter {

//    @Autowired
//    public CategoryRepository categoryRepository;
//    @Bean
//    public RouterFunction<ServerResponse> getAllCategoriesRoute() {
//        return route(GET("/category"),
//                req ->
//                        ok().body(fromValue(
//                                categoryRepository.findAll()))
//        );
//    }
}