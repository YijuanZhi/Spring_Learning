package com.antra;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j
@Component
public class MessageGeneratorImpl implements MessageGenerator {
//    private final static Logger log = LoggerFactory.getLogger(MessageGeneratorImpl.class);

//    @Autowired
    private final Game game;

    //Constructor
    @Autowired
    public MessageGeneratorImpl(Game game) {
        this.game = game;
    }

    @PostConstruct
    public void reset(){
        log.info("From reset() method: the Message Generator is created, the number is {}.", game.getGuessCount());
        log.info("game = {}", game);
    }


    @Override
    public String getMainMessage() {
        return "Number is between " +
                game.getSmallest() + " and " +
                game.getBiggest() +
                ". Can you guess the number?";
    }

    @Override
    public String getResultMessage() {
        if(game.isGameWon()){
            return "You guessed it! The number was " + game.getNumber();
        }else if(game.isGameLost()){
            return "You lost! The number is " + game.getNumber();
        }else if(!game.isValidNumber()){
            return "Invalid number range!";
        }else if(game.getRemainingGuesses() == game.getGuessCount()){
            return "What is your first guess?";
        }else{
            String direction = "Lower";

            if(game.getGuess() < game.getNumber()){
                direction = "Higher";
            }

            return direction + "! You have " + game.getRemainingGuesses() + " guesses left!";
        }
    }
}
