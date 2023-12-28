package com.sarp.lambda.chap6;


import java.util.Arrays;
import java.util.List;
import java.util.Spliterator;

class Car {
    String manu;
    String model;
    Car(String x, String y) {
        manu = x;
        model = y;
    }

    @Override
    public String toString() {
        return (manu + "," + model);
    }
}
public class IteratorExample {


    static List<Car> cars = Arrays.asList(
            new Car("Nissan", "Sentra"),
            new Car("Chevrolet", "Vega"),
            new Car("Hyundai", "Elantra"),
            new Car("Buick", "Regal")
    );

    public static void main(String[] args) {
        List<Car> cars = Arrays.asList(
                new Car("Nissan", "Sentra"),
                new Car("Chevrolet", "Vega"),
                new Car("Hyundai", "Elantra"),
                new Car("Buick", "Regal")
        );

        Spliterator<Car> firstHalf = cars.spliterator();
        Spliterator<Car> secondHalf = firstHalf.trySplit();

        firstHalf.forEachRemaining(x ->
                System.out.println("In 1st half: " + x));
        secondHalf.forEachRemaining(x ->
                System.out.println("In 2nd half: " + x));
    }
}