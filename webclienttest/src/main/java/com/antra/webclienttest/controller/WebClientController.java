package com.antra.webclienttest.controller;

import com.antra.webclienttest.service.WebClientService;
import com.antra.webclienttest.util.Quote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class WebClientController {

    private final WebClientService webClientService;

    @Autowired
    public WebClientController(WebClientService webClientService) {
        this.webClientService = webClientService;
    }

    @GetMapping("/")
    public Mono<Object> getData(){
        return webClientService.get();
    }

    @GetMapping("/quote")
    public Quote getQuote(){
        return webClientService.getQuote();
    }
}
