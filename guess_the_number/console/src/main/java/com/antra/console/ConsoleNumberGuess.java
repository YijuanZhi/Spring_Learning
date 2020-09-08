package com.antra.console;

import com.antra.Game;
import com.antra.MessageGenerator;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Slf4j
@Component
public class ConsoleNumberGuess implements ApplicationListener<ContextRefreshedEvent> {
    // constants
//    private final static Logger log = LoggerFactory.getLogger(ConsoleNumberGuess.class);

    //fields
//    @Autowired
    private final Game game;
//    @Autowired
    private final MessageGenerator messageGenerator;

    //constructor injection!
    @Autowired
    public ConsoleNumberGuess(Game game, MessageGenerator messageGenerator) {
        this.game = game;
        this.messageGenerator = messageGenerator;
    }
    /*
         1. you could use @EventListener instead of let the class implements the ApplicationListener interface, in this way
            this method can be called any name like start(ContextRefreshedEvent event).
         2. or if you want the method to be start() without any parameter, you can use @EventListener(ContextRefreshedEvent.class)
     */
    //@EventListener
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        log.info("ConsoleNumberGuess started: Container ready to use.");
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("THIS MESSAGE COMES FROM ConsoleNumberGuess.java.");
            System.out.println(messageGenerator.getMainMessage());
            System.out.println(messageGenerator.getResultMessage());

            int guess = sc.nextInt();
            sc.nextLine();
            game.setGuess(guess);
            game.check();

            if(game.isGameWon() || game.isGameLost()){
                System.out.println(messageGenerator.getResultMessage());
                System.out.println("Do you want to play again? y/n");

                String playAgain = sc.nextLine();
                if(!playAgain.equalsIgnoreCase("y")) break;

                game.reset();
            }
        }
    }
}
