package com.antra;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Slf4j
@Service
public class GameServiceImpl implements GameService {

    //fields
    private final Game game;
    private final MessageGenerator messageGenerator;

    //constructor
    @Autowired
    public GameServiceImpl(Game game, MessageGenerator messageGenerator){
        this.game = game;
        this.messageGenerator = messageGenerator;
    }

    @PostConstruct
    public void init(){
        log.info("GameServiceImpl bean created");
    }

    @PreDestroy
    public void preDestory(){
        log.info("GameServiceImply pre destoried.");
    }

    //overriding methods
    @Override
    public boolean isGameOver() {
        return game.isGameLost() || game.isGameWon();
    }

    @Override
    public String getMainMessage() {
        return messageGenerator.getMainMessage();
    }

    @Override
    public String getResultMessage() {
        return messageGenerator.getResultMessage();
    }

    @Override
    public void checkGuess(int guess) {
        game.setGuess(guess);
        game.check();
    }

    @Override
    public void reset() {
        game.reset();
    }
}
