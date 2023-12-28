package com.sarp.lambda.chap6;


import java.util.*;
import java.util.function.BiFunction;
import java.util.function.IntBinaryOperator;
import java.util.function.IntFunction;
import java.util.function.IntToLongFunction;

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



    public static void main(String[] args) {
//        List<Car> cars = Arrays.asList(
//                new Car("Nissan", "Sentra"),
//                new Car("Chevrolet", "Vega"),
//                new Car("Hyundai", "Elantra"),
//                new Car("Buick", "Regal")
//        );
//
//        Spliterator<Car> firstHalf = cars.spliterator();
//        Spliterator<Car> secondHalf = firstHalf.trySplit();
//
//        firstHalf.forEachRemaining(x ->
//                System.out.println("In 1st half: " + x));
//        secondHalf.forEachRemaining(x ->
//                System.out.println("In 2nd half: " + x));
//
        IntToLongFunction gen5 = x -> 5;
        long[] larr = new long[4];
        Arrays.setAll(larr, gen5);


        for (long l : larr)
            System.out.println(l);

        IntFunction<String> is = x -> {
            String s = "";
            for (int i=0; i<=x; ++i)
                s += "S";
            return s;
        };
        String[] sarr = new String[4];
        Arrays.setAll(sarr, is);
        for (String s : sarr)
            System.out.println(s);


        Map<String,String> map = new TreeMap<>();
        map.put("Smith", "Robert");
        map.put("Jones", "Alex");
        BiFunction<String,String,String> bi = (k, v) -> "Mr. " + v;
        map.replaceAll(bi);
        map.forEach( (x,y) -> System.out.println(y + " " + x));


        int[] arr = {2,3,4,3};
        IntBinaryOperator op = (x, y) -> x * y;
        Arrays.parallelPrefix(arr, op);
        for (int i: arr)
            System.out.println(i);

    }
}