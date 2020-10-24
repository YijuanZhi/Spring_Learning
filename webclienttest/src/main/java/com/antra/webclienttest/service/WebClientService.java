package com.antra.webclienttest.service;
//for this service class, you better use an interface to implement this class!

import com.antra.webclienttest.util.Quote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class WebClientService {

    private final WebClient webClient;
    private final RestTemplate restTemplate;

    @Autowired
    public WebClientService(WebClient webClient, RestTemplate restTemplate) {
        this.webClient = webClient;
        this.restTemplate = restTemplate;
    }

    public Mono<Object> get() {
        return webClient.get()
                .uri("woof.json")
                .retrieve()
                .bodyToMono(Object.class); //to pojo, just create a class that this json can be converted to
    }

    public Quote getQuote(){
        return restTemplate.getForObject("https://gturnquist-quoters.cfapps.io/api/random", Quote.class);
    }
}
