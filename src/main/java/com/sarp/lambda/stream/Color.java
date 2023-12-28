package com.sarp.lambda.stream;

import java.util.function.Predicate;
import java.util.stream.Stream;

public class Color {
    public static void main(String[] args) {
//        Stream.of("RED","GREEN","BLUE","RED")
//                .filter(x->x.equals("RED"))
//                .forEach(x-> System.out.println(x));


        Predicate<String> isRed = x -> x.equals("RED");

        Stream.of("RED", "GREEN", "BLUE", "RED")
                .filter(isRed.or(x -> x.indexOf("R") > -1))
                .forEach(x -> System.out.println(x));
    }
}
