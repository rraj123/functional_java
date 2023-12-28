package com.sarp.lambda.chap2;

@FunctionalInterface
interface FIVoid2
{
    void method1(int i);
}
public class TestLambdaScope {
    private static int myField = 2;
    public static void main(String[] args) {
      int myLocal = 7;
      FIVoid2 lambdaVoid = x -> System.out.println(x + myField + myLocal);
      lambdaVoid.method1(5);
    }
}
