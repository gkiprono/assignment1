package java_basic.day4.streamapi;

import day4.models.Employee;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Driver {
    public static void main(String[] args) {
        List<SampleClass> employee = new ArrayList<>();

        employee.add(new SampleClass("Gabe Kip", 23, 1235));
        employee.add(new SampleClass("Kip Kip", 24, 1235));
        employee.add(new SampleClass("Zao Kip", 25, 1235));
        employee.add(new SampleClass("Megan Kip", 20, 1235));
        employee.add(new SampleClass("Theta Alpha", 18, 1235));
        employee.add(new SampleClass("Kappa Union", 17, 1235));
        employee.add(new SampleClass("Alpha Member", 15, 1235));
        employee.add(new SampleClass("Super Class", 14, 1235));


        mapStream();
        filterStream(employee);
        forEachStream(employee);
        flatmapStream();
        distinctStream();
        limitStream();
        sortStream(employee);

        try{
            minAndMaxStream(employee);
        }catch (NoSuchElementException n){
            n.printStackTrace();
        }

        matchStream();
        intStream(employee);
        reductionStream(employee);

    }

    // 1.0 Maps ~ demonstration of map
    public static void mapStream(){
        System.out.println("*************** map stream ****************");
        List<Integer> number = Arrays.asList(20,3,4,5,60,55,15,21);
        List<Integer> numberSquares = number.stream().map(x -> x*x).collect(Collectors.toList());
        System.out.println(numberSquares);

    }

    // 2.0 Filter method
    public static void filterStream(List<SampleClass> employee){
        System.out.println("*************** filter stream ****************");
        List<Integer> number = Arrays.asList(20,3,4,5,60,55,15,21);

        // filter no less than 20
        List<Integer> lessthan20 = number.stream().filter(x -> x < 20).collect(Collectors.toList());
        System.out.println(lessthan20); // 3,4,5,15

        //find employee 20yrs and younger
        List<SampleClass> emp = employee.stream().filter(x -> x.getAge() < 20).collect(Collectors.toList());
        emp.forEach(y -> System.out.println(y.toString()));

        System.out.println();
        //find employee whose name starts with k
        List<SampleClass> em = employee.stream().filter(e -> e.getName().startsWith("K")).collect(Collectors.toList());
        em.forEach(y -> System.out.println(y.toString()));
    }

    // 3.0 flatmap -> flattens the map
    public static void flatmapStream(){
        System.out.println("*************** flat map ****************");
        List<Integer> number = Arrays.asList(20,3,4,5,60,55,15,21);

        List<Integer> numberSquares = number.stream().map(x -> x*x).collect(Collectors.toList());
        System.out.println("flat map effect");
        numberSquares.stream().flatMap(num -> Stream.of(num)).forEach(System.out::println);
        System.out.println("Before flatmap");
        System.out.println(numberSquares);

        //flat stream on strings
        List<String> stringList = Arrays.asList("Java","has","never","been","this","fun");
        stringList.stream().flatMap(str -> Stream.of(str)).forEach(System.out::println);

    }

    // 4.0 forEach
    public static void forEachStream(List<SampleClass> employee){
        System.out.println("*************** for each stram ****************");
        // print out all employees
        employee.forEach(em -> System.out.println(em.toString()));

        // print cube of this numbers
        List<Integer> number = Arrays.asList(20,3,4,5,60,55,15,21);
        number.stream().map(x->Math.pow(x,3)).forEach(n -> System.out.println(n));
    }
    // 5.0 distinct -> returns the distinct elements
    public static void distinctStream(){
        System.out.println("*************** distinct stream ****************");
        List<Integer> number = Arrays.asList(20,20,3,4,5,60,55,15,21,60,55,15);
        System.out.println("distinct elements");
        List<Integer> distinct = number.stream().distinct().collect(Collectors.toList());
        Long count = distinct.stream().count();
        System.out.println("no. of distict elements are: "+count);
        System.out.println(distinct);
    }
    // 6.0 limit takes size n and returns a stream no more than size(n)
    public static void limitStream(){
        System.out.println("*************** limit stream ****************");
        List<Integer> number = Arrays.asList(20,20,3,4,5,60,55,15,21,60,55,15);
        System.out.println("limit elements");

        // limit above list to 4
        number.stream().limit(4).forEach(System.out::println);

        List<String> stringList = Arrays.asList("Java","has","never","been","this","fun");
        // limiting above string
        stringList.stream().limit(3).forEach(System.out::println);
    }

    // 7.0 Sorted, -> comparison based stream operations
    public static void sortStream(List<SampleClass> employee){
        System.out.println("*************** sort stream with limit ****************");
        List<SampleClass> empployeeSorted = employee.stream()
                .sorted((emp1,emp2) -> emp1.getName().compareTo(emp2.getName()))
                .collect(Collectors.toList());

        empployeeSorted.stream().limit(5).forEach(System.out::println);
    }

    // 8.0 Min and max -> returns the minimum and maximum element in the stram
    // find the youngest and oldest employee
    public static void minAndMaxStream(List<SampleClass> employee) throws NoSuchElementException {
        System.out.println("*************** min and max stream ****************");
        SampleClass young = employee.stream().min((emp1,emp2) -> emp1.getAge() - emp2.getAge())
                .orElseThrow(NoSuchElementException::new);

        System.out.println(young.toString());

        // older but using comparator.comparing
        SampleClass old = employee.stream().max(Comparator.comparing(SampleClass::getAge))
                .orElseThrow(NoClassDefFoundError::new);

        System.out.println(old.toString());
    }

    // 9.0 allmatch, nomatch,nonematch
    public static void matchStream(){
        System.out.println("*************** match stream ****************");
        List<Integer> number = Arrays.asList(20,20,5,8,4,2);

        boolean allEven = number.stream().allMatch(num -> num%2 == 0); // false
        boolean oneEven = number.stream().anyMatch(num -> num%2 == 0); // true
        boolean oneOdd = number.stream().anyMatch(num -> num%2 == 1); // true
        boolean multipleofsix = number.stream().noneMatch(num -> num%6 == 0); //true

        System.out.println(number);
        System.out.println("All even? :" + allEven);
        System.out.println("Atleast one even? :" + oneEven);
        System.out.println("Atleast one odd? :" + oneOdd);
        System.out.println("Any multiple of 6?: " + !multipleofsix);

    }

    /*
    *  Java Stream Specializations i.e intstream(int), longstream(long), doublestream(double)
    *
    * */

    // 10.0 Creation of intStream using mapToInt()
    public static void intStream(List<SampleClass> employee){
        System.out.println("*************** Integer Stream ****************");
        // find age of oldest employee
        Integer oldest = employee.stream().mapToInt(SampleClass::getAge)
                .max().orElseThrow(NoClassDefFoundError::new);

        System.out.println("Oldest employee is: " + oldest + " years old.");


//        IntStream.range(10,20).forEach(i -> System.out.println(i));

        Double avgAge = employee.stream().mapToDouble(SampleClass::getAge)
                .average().orElseThrow(NoClassDefFoundError::new);

        System.out.println("Average Age of employees: " + avgAge);

    }

    // 11.0 Reduction operation -> takes sequence of input elements and combines them to a single summary result

    public static void reductionStream(List<SampleClass> employee){
        System.out.println("*************** Reduction Stream ****************");
        // reduce -> this finds sum of employee ages by applying reduce
        Integer sumOfAges = employee.stream().map(SampleClass::getAge).reduce(0,Integer::sum);

        System.out.println("Sum of ages of all employees: " + sumOfAges);
    }


}
