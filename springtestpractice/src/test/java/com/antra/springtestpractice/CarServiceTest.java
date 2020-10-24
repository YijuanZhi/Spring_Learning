package com.antra.springtestpractice;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

//run with MockitoJUnitRunner class as an example of pure unit test
@RunWith(MockitoJUnitRunner.class)
public class CarServiceTest {

    @Mock
    private CarRepository carRepository;

    private CarService carService;

    @Before
    public void setup(){
        carService = new CarService(carRepository);
    }

    @Test
    public void getCarDetails_returnsCarInfo(){
        given(carRepository.findByName("civic")).willReturn(new Car("civic", "car"));

        Car car = carService.getCarDetails("civic");

        assertThat(car.getName()).isEqualTo("civic");
        assertThat(car.getType()).isEqualTo("car");
    }

    @Test(expected = CarNotFoundException.class)
    public void getCarDetails_whenCarNotFound() throws Exception {
        given(carRepository.findByName("civic")).willReturn(null);

        carService.getCarDetails("civic");
    }

}