package com.sarp.lambda.optional;

import java.util.Optional;

public class OptionalTest {
    public static void main(String[] args) {
        Optional.of("Hsello")                            // Optional(Hello)
                .filter(x -> x.charAt(0) == 'H')        // Optional(Hello)
                .filter(x -> x.length() > 2)            // Optional(Hello)
                .filter(x -> x.charAt(1) == 'e')        // Optional(Hello)
                .ifPresent(x -> System.out.println(x)); // Prints "Hello"


        Optional<String> optionalString = Optional.of("Hello, World!");

        if (optionalString.isPresent()) {
            System.out.println(optionalString.get()); // Outputs: Hello, World!
        }

        // Alternative approach using lambda
        optionalString.ifPresent(System.out::println);

        // Using orElse to provide a default value
        String nullString = null;
        String result = Optional.ofNullable(nullString).orElse("Default Value");
        System.out.println(result); // Outputs: Default Value

    }
}
