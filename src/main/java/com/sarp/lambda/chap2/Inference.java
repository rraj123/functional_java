package com.sarp.lambda.chap2;
class A { int i; }

@FunctionalInterface
interface Z<T>
{
    int m(T t);
}

class Inference
{
    static <T> void m2(Z<T> arg) {}
    public static void main(String[] args)
    {
        m2((A x) -> x.i); // ERROR
    }
}