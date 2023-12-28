package com.sarp.lambda.stream;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

class Student {
    String name;
    int rollNo;
    double gpa;

    public Student(String name, int rollNo, double gpa) {
        this.name = name;
        this.rollNo = rollNo;
        this.gpa = gpa;
    }
}
class Class
{
    String subject;
    Collection<Student> students;
    public Class(String su, Student... st)
    {
        subject = su;
        students = Arrays.asList(st);
    }
}

public class ClassEx
{
    public static void main(String[] args)
    {
        Stream.of(new Class("Biology",
                                new Student("Joe" ,1001,3.81),
                                new Student("Mary",1002,3.91)),
                        new Class("Physics",
                                new Student("Kalpana",1003,3.61),
                                new Student("Javier" ,1004,3.71))) // Stream<Class>
                .flatMap(x -> x.students.stream())        // Stream<Student>
                .forEach(x -> System.out.println(x));
    }
}