package com.webfluxpoc.callerservice.repository;

import com.webfluxpoc.callerservice.model.Player;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

interface PlayerRepository extends ReactiveCrudRepository<Player, Integer> {
    @Query("select id, name, age from player where name = $1")
    Flux<Player> findAllByName(String name);

    @Query("select * from player where age = $1")
    Flux<Player> findByAge(int age);
}

