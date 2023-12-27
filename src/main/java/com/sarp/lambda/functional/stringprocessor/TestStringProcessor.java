package com.sarp.lambda.functional.stringprocessor;


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
public class TestStringProcessor {
    public static void main(String[] args)
    {
        NamedStringProcessor namedSP = new NamedStringProcessor();
        StringProcessor anonSP = new StringProcessor() {
            @Override
            public String process(String x)
            {
                return x.toUpperCase();



            }
        };
        System.out.println(namedSP.process("hello"));
        System.out.println(anonSP.process("hello"));
    }
    // Anonymous class that provides the functional method
    StringProcessor anonSP = new StringProcessor() {
        @Override
        public String process(String x)
        {
            return x.toUpperCase();
        }
    };
}
