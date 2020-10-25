package com.antra.springtestpractice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Car getCarDetails(String s) {
        Car car = carRepository.findByName(s);
        if(car == null) throw new CarNotFoundException();
        else return car;
    }
}
