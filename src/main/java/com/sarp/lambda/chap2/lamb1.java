package com.sarp.lambda.chap2;

@FunctionalInterface
interface FIVoid
{
    void method1(int i);
}
public class lamb1 {
    public static void main(String[] args) {
        FIVoid LambdaVoid = x -> System.out.println(x);
        LambdaVoid.method1(5);
    }
}
