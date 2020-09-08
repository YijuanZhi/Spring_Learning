package com.antra;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Setter
@Slf4j
@Getter
@Component
public class GameImpl implements Game{

    // constants
//    private static final Logger log = LoggerFactory.getLogger(GameImpl.class);

    //fields
    //with @Autowired, we do not need a constructor or a setter method, it will be handled by spring container
    // this annotation is added to the parameters of constructor(recommended) or setter method

//    @Autowired
    @Getter(AccessLevel.NONE) //we don't want numberGenerator to be accessible by a getter method
    private final NumberGenerator numberGenerator;
//    @Autowired @GuessCount
    private final int guessCount;
    private int number;
    @Setter private int guess;
    private int smallest;
    private int biggest;
    private int remainingGuesses;
    private boolean validNumberRange = true;

    // 1. constructor (constructor based dependency injection)
    @Autowired
    public GameImpl(NumberGenerator numberGenerator, @GuessCount int guessCount) {
        this.numberGenerator = numberGenerator;
        this.guessCount = guessCount;
    }

    // 2. setter (setter based dependency injection)
    // this method will be automatically called when this dependency strategy is used
//    public void setNumberGenerator(NumberGenerator numberGenerator){
//        this.numberGenerator = numberGenerator;
//    }

    // init
    //@PostConstruct will automatically run after the construction
    @Override
    @PostConstruct
    public void reset() {
        smallest = numberGenerator.getMinNumber();
        biggest = numberGenerator.getMaxNumber();
        number = numberGenerator.next();
        guess = 0;
        remainingGuesses = guessCount;

        log.debug("From reset() method: this number is {}", number);
    }

    @PreDestroy
    public void preDestroy(){
        log.info("In Game preDestroy().");
    }

    //public methods
//    @Override
//    public int getNumber() {
//        return number;
//    }
//
//    @Override
//    public int getGuess() {
//        return guess;
//    }

    //setter method
//    @Override
//    public void setGuess(int guess) {
//        this.guess = guess;
//    }

    //getter methods
//    @Override
//    public int getSmallest() {
//        return smallest;
//    }
//
//    @Override
//    public int getBiggest() {
//        return biggest;
//    }
//
//    @Override
//    public int getRemainingGuesses() {
//        return remainingGuesses;
//    }
//
//    @Override
//    public int getGuessCount() {
//        return guessCount;
//    }
//
    @Override
    public boolean isValidNumber() {
        return validNumberRange;
    }


    @Override
    public void check() {
        checkValidNumberRange();
        if(validNumberRange){
            if(guess > number){
                biggest = guess - 1;
            }
            if(guess < number){
                smallest = guess + 1;
            }
        }
        remainingGuesses --;
    }



    @Override
    public boolean isGameWon() {
        return guess == number;
    }

    @Override
    public boolean isGameLost() {
        return !isGameWon() && remainingGuesses == 0;
    }

    //private methods
    private void checkValidNumberRange(){
        validNumberRange = (guess >= smallest) && (guess <= biggest);
    }
}
