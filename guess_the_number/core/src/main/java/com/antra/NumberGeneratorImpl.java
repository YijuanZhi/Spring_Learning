package com.antra;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;
//in Main.class:
//NumberGenerator numberGenerator = context.getBean("generator", NumberGenerator.class);
//uses the component name "generator"
@Component("generator")
public class NumberGeneratorImpl implements NumberGenerator{

    //fields
    private final Random random = new Random();

    //instead of field injection, we are recommended to use the constructor injection
    // @Autowired @MaxNumber
    @Getter private final int maxNumber;
    // @Autowired @MinNumber
    @Getter private final int minNumber;


    // constructor
    @Autowired
    public NumberGeneratorImpl(@MaxNumber int maxNumber, @MinNumber int minNumber) {
        this.maxNumber = maxNumber;
        this.minNumber = minNumber;
    }

    //public methods
    @Override
    public int next() {
        return random.nextInt(maxNumber-minNumber) + minNumber;
    }

//    @Override
//    public int getMaxNumber() {
//        return maxNumber;
//    }
//
//    @Override
//    public int getMinNumber() { return minNumber;}
}
