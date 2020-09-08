package com.antra.config;

import com.antra.GuessCount;
import com.antra.MaxNumber;
import com.antra.MinNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:config/game.properties") //we are going to use the game.properties from config folder for configuration
public class GameConfig {

    //fields

    //these values are imported from the @PropertySource, which is game.properties
    //if the game.maxNumber exists in the properties file, then use the value
    //if not defined, it is going to use the default value 20
    @Value("${game.maxNumber:200}")
    private int maxNumber;

    @Value("${game.guessCount:20}")
    private int guessCount;

    @Value("${game.minNumber:0}")
    private int minNumber;
    //bean methods

    //because we wire with custom annotation @MaxNumber, now the bean method does not be same as the variable name
    @Bean
    @MaxNumber
    public int maxNumber123(){
        return maxNumber;
    }

    @Bean
    @GuessCount
    public int guessCount123(){
        return guessCount;
    }

    @Bean
    @MinNumber
    public int minNumberwtf(){return minNumber; }
}
