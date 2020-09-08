package com.antra.config;

import com.antra.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

// since we can use @Component for all bean management,
// 1. we could delete this file and use GameConfig.java as @ComponentScan(basePackages = "com.antra") file,
// 2. and change the
// ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class)
// to
// ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(GameConfig.class)
@Configuration
@Import(GameConfig.class) // this could allow modularized configuration
@ComponentScan(basePackages = "com.antra")
public class AppConfig {

    //beans methods

    // 1. using these beans method instead of @Component annotation could provide more configuration for the beans
    // for example, in GameConfig.java, we can config the values of the beans instead of using same value everytime.
    // 2. we do not need these bean methods, we can just use @Component in the class we want spring to create an instance,
    //the container will manage the beans instead.

//    @Bean("generator")
//    public NumberGenerator numberGenerator(){
//        return new NumberGeneratorImpl();
//    }

//    @Bean
//    public Game game(){
//        return new GameImpl();
//    }

//    @Bean
//    public MessageGenerator messageGenerator(){
//        return new MessageGeneratorImpl();
//    }
}
