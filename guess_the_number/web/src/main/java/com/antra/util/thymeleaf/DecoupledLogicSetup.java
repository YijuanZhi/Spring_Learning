package com.antra.util.thymeleaf;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;

import javax.annotation.PostConstruct;

/*
this files enables the functionality that separates the thymeleaf attributes and the html file
so that we can manage the thymeleaf file independently
*/
@Slf4j
@Component
public class DecoupledLogicSetup {

    //fields
    private final SpringResourceTemplateResolver templateResolver;

    //constructor
    public DecoupledLogicSetup(SpringResourceTemplateResolver templateResolver) {
        this.templateResolver = templateResolver;
    }

     //init template resolver
    @PostConstruct
    public void init(){
        templateResolver.setUseDecoupledLogic(true);
        log.info("Thymeleaf decoupled template resolver enabled");
    }
}
