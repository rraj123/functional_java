package com.sarp.lambda.chap3;

import java.util.function.Function;

class Transformer
{
    private static <T,R> R transform(T t, Function<T, R> f)
    {
        return f.apply(t);
    }
    public static void main(String[] args)
    {
        Function<String , Integer> fsi = x -> Integer.parseInt(x);
        Function<Integer, String>  fis = x -> Integer.toString(x);
        Integer i = transform("100", fsi);
        String  s = transform(200  , fis);
        System.out.println(i);
        System.out.println(s);
    }
}
