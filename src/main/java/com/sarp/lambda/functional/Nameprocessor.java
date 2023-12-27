package com.sarp.lambda.functional;

@FunctionalInterface
interface StringProcessor
{
    String process(String x);
}
class NamedStringProcessor implements StringProcessor
{
    @Override
    public String process(String s) { return s; }
}
public class Nameprocessor {
    public static void main(String[] args) {
        NamedStringProcessor namedSP = new NamedStringProcessor();
        System.out.println(namedSP.process("hello"));

        StringProcessor annoSP = new StringProcessor() {
            @Override
            public String process(String x) {
                return x.toUpperCase();
            }
        };
        System.out.println(annoSP.process("hello"));

    }
}
