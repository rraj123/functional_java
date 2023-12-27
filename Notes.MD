## Functional Interface - Notes

### Rules 
#### Enhancements to Interfaces in Java 8 and Java 9
``Pay attention to the interface qualifiers``

1. Interfaces can static and default methods.
   A default method is an implementation provided by the interface that does not have to be overridden by an implementing class. Default methods help in the compilation of legacy code.
2. Static Interface methods. 
   In Java 9, interfaces can also have private static methods. Since the static methods of an interface can be called without creation of an implementing object, these methods can only be called by public static methods defined in the interface.


#### Enhancements to Interfaces in Java 8 and Java 9
Section 1.3: Functional Interfaces Defined
1. A functional interface is an interface **with a single abstract method**, called its functional method. 

#### Providing Default Methods in Functional Interfaces
A functional interface can provide default methods. An implementing class can use the default methods or provide its own versions.

#### Providing Static Methods in Functional Interfaces

#### Generic Functional Interfaces
1. Many of the functional interfaces defined in the Java API are generic for one or more types. Suppose a program needs methods that take two arguments of a type and returns a result of the same type, but both the type and the operation performed can vary
`Type could be anything.`

````
@FunctionalInterface
interface TwoArgsProcessor<X> {
    X process(X arg1, X arg2);
}
````
#### Generic Functional Interfaces with Type Restrictions


