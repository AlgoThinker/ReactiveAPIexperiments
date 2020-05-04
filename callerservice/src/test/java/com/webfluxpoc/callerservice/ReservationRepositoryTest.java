package com.webfluxpoc.callerservice;

import com.webfluxpoc.callerservice.ReservationRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class ReservationRepositoryTest {

    @Autowired
    private ReservationRepository reservationRepository;

    @Test
    public void test_all(){
//        Flux<Void> deleteAll = this.reservationRepository.findAll()
//                .flatMap(r->this.reservationRepository.deleteById(r.getId()));
//        StepVerifier.create(deleteAll).expectNextCount(0).verifyComplete();
//        List<String> list = new ArrayList<>();
//        list.add("brad");
//        list.add("pitt");
//        list.add("john");
//        list.add("miller");
//
//        Flux<Reservation> reservationFlux = Flux.just(list.)
//                .map(name->new Reservation(null,))
//                .flatMap(r->this.reservationRepository.save(r));
//        StepVerifier.create(reservationFlux).expectNextCount(4).verifyComplete();
//
//        Flux<Reservation> all = this.reservationRepository.findAll();
//        StepVerifier.create(all).expectNextCount(3).verifyComplete();

        this.reservationRepository.findAll().as(StepVerifier::create).expectNextCount(7).verifyComplete();
    }


}