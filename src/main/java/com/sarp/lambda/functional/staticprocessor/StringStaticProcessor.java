package com.sarp.lambda.functional.staticprocessor;


public class StringStaticProcessor {
    public static void main(String[] args) {
        StringProcessor toLowerCase = new StringProcessor() {
            @Override
            public String process(String s)
            {
                return s.toLowerCase();
            }
        };
        StringProcessor toUpperCase = new StringProcessor() {
            @Override
            public String process(String s)
            {
                return s.toUpperCase();
            }
        };

        String s = toLowerCase.process("FUNCTIONALINTERFACES");
        System.out.println(s);
        System.out.println("Lower case: " + StringProcessor.isLowerCase(s));
        System.out.println("Upper case: " + StringProcessor.isUpperCase(s));
        String t = toUpperCase.process(s);
        System.out.println("\n" + t);
        System.out.println("Lower case: " + StringProcessor.isLowerCase(t));
        System.out.println("Upper case: " + StringProcessor.isUpperCase(t));
    }
}

@FunctionalInterface
interface StringProcessor
{
    String process(String s);
    static boolean isLowerCase(String s)
    {
        boolean result = true;
        for (int i = 0; i < s.length() && result; ++i)
            result &= Character.isLowerCase(s.charAt(i));
        return result;
    }
    static boolean isUpperCase(String s)
    {
        boolean result = true;
        for (int i = 0; i < s.length() && result; ++i)
            result &= Character.isUpperCase(s.charAt(i));
        return result;
    }
}