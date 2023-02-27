package org.example;

public class Main {
    public static void main(String[] args) {

        Car car1 = new Car("BMW1", 1);
        Car car2 = new Car("BMW1", 1);
        System.out.println(car1==car2);

    }
}