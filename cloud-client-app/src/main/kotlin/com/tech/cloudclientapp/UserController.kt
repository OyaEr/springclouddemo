package com.tech.cloudclientapp

import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
class UserController {

    @Value("\${app.adminusername}")
    var username="Test"

    //get request serving
    @GetMapping("/whoami")
    fun whoami() = "I am a  "+ username

    @GetMapping("/flux")
    fun getFlux() : Flux<Int> {
        return Flux.just(1,2,3).log()
    }

    @GetMapping("/mono")
    fun getMono() : Mono<String> {
        return Mono.just("Hello, World!").log()
    }

    /*
    Mono<String> stringMono = Mono.just("Hey n11");
    Mono<Integer> integerMono = Mono.just(1);
    Mono<Object> monoError = Mono.error(new RuntimeException());
    Mono<Object> monoEmpty = Mono.empty();

    Flux<String> stringFlux = Flux.just("Hello", "Reader", "World");
    Flux<Integer> fluxRange = Flux.range(1,5);
    Flux<Long> longFlux = Flux.interval(Duration.ofSeconds(1));
    */


}