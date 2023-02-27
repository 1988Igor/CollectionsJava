package org.example;

import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class CarListTestTest {


    private CarList carList;

    @BeforeEach
    void setUp() throws Exception {
        carList = new CarLinkedList();
        for(int i =0; i < 100; i++){
            carList.add(new Car("Brand" +i, i));
        }

    }
    @Test
    public void whenAdded100ElementsThenSizeMustBe100(){
        Assertions.assertEquals(100,carList.size());
    }

    @Test
    public void whenElementRemovedByIndexThenSizeMustBeDecreased(){
        Assertions.assertTrue(carList.removeAT(5));
        Assertions.assertEquals(99,carList.size());
    }
    @Test
    public void whenElementRemovedThenSizeMustBeDecreased(){
        Car car = new Car("Toyota", 5);
        carList.add(car);
        Assertions.assertEquals(101, carList.size());
        Assertions.assertTrue(carList.remove(car));
        Assertions.assertEquals(100,carList.size());
    }

    @Test
    public void whenNonExistentElementRemovedThenReturnFalse(){
        Car car = new Car("Toyota", 5);
        Assertions.assertFalse(carList.remove(car));
        Assertions.assertEquals(100, carList.size());
    }
    @Test
    public void whenListClearedThenSizeMustBe0(){
        carList.clear();
       Assertions.assertEquals(0, carList.size());
    }

    @Test
    public void whenIndexOutOfBoundsThenThrownException() {

        Throwable exception = assertThrows(IndexOutOfBoundsException.class, () -> {
            carList.get(100);
        });
    }

    @Test
    public void methodGetReturnedRightValue() {
        Car car = carList.get(0);
        Assertions.assertEquals("Brand0", car.getBrand());
    }
    @Test
    public  void insertInTheMiddle(){
        Car car = new Car("BMW", 1);
        carList.add(car,50);
        Car carFromList = carList.get(50);
        assertEquals("BMW", carFromList.getBrand());
    }
    @Test
    public  void insertInTheFirstPosition(){
        Car car = new Car("BMW", 1);
        carList.add(car,0);
        Car carFromList = carList.get(0);
        assertEquals("BMW", carFromList.getBrand());
    }

    @Test
    public  void insertInTheLastPosition(){
        Car car = new Car("BMW", 1);
        carList.add(car,100);
        Car carFromList = carList.get(100);
        assertEquals("BMW", carFromList.getBrand());
    }
}
