package com.antra.springtestpractice;

public class Car {
    private String type;
    private String name;

    public Car(String name, String type) {
        this.name = name;
        this.type = type;
    }
    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }


}
