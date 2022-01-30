#### January 28, 2022

*Author: Gabriel Kiprono*

---
# Homework 4.1
## Type Erasure
Type erasure is a process in which compiler replaces generic parameter with actual class. Compiler makes sure there is no
extra classes created and no runtime overhead. Enables programmers to specify, with a single method declaration, a set of related
methods, or with a single class declaration, a set of related types respectively.

#### Bound types erasure
Java Compiler replaces type parameters in generic type with their bound if bounded type parameters are used.
```java
public class RectangleDriver{
    public static void main(String[] args) {
        // any number type can be used
        Rectangle<Integer> rectangle = new Rectangle<>();
        Rectangle<Double> rect = new Rectangle<>();
    }

}
class Rectangle<T extends Number>{
    private T t;

    public void add(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }
    
}
```
in above case, java compiler will replace T with Number class.

#### Unbounded types erasure
Java Compiler replaces type parameters in generic type with Object if unbounded type parameters are used.

```java
public class RectangleDriver{
    public static void main(String[] args) {
        // any number type can be used
        Rectangle<Integer> rectangle = new Rectangle<>();
        Rectangle<Double> rect = new Rectangle<>();
    }

}
class Rectangle<T>{
    private T t;

    public void add(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }
    
}
```
in above case,java compiler will replace T with Object class. Also, java compiler replaces type parameters in generic type in methods.

## Generics

- < T extends E> same as upper bounded wildcard
- < ? extends E > **upper bounded wildcard** the question mark represents the unknown types in generics. It allows flexibility such that anu object can be
    used when the code is independent of the type parameter
```java
class Generics {
    public static double sum(List<? extends Number> numberlist) {
        double sum = 0.0;
        for (Number n : numberlist) sum += n.doubleValue();
        return sum;
    }

    public static void main(String args[]) {
        List<Integer> integerList = Arrays.asList(1, 2, 3);
        System.out.println("sum = " + sum(integerList));

        List<Double> doubleList = Arrays.asList(1.2, 2.3, 3.5);
        System.out.println("sum = " + sum(doubleList));
    }
}
```
- < ? super T > **lower bounded wildcard** There may be times when you'll want to restrict the kinds of types that are allowed to be passed to a type 
parameter. For example, a method that operates on numbers might only want to accept instances of Integer or its superclasses like Number.
```java
class LowerBoundWildcard {
    public static void addCat(List<? super Cat> catList) {
        catList.add(new RedCat());
        System.out.println("Cat Added");
    }

    public static void main(String[] args) {
        List<Animal> animalList = new ArrayList<Animal>();
        List<Cat> catList = new ArrayList<Cat>();
        List<RedCat> redCatList = new ArrayList<RedCat>();
        List<Dog> dogList = new ArrayList<Dog>();
        //add list of super class Animal of Cat class
        addCat(animalList);

        //add list of Cat class
        addCat(catList);
    }
}
 
abstract class Animal {}

class Cat extends Animal {}

class RedCat extends Cat {}

class Dog extends Animal {}
  ```

# Homework 4.2
### Explore other stream API (10 api's)
- map, flatmap, distinct, limit
- method reference
- others;