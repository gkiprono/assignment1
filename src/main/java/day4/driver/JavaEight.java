package day4.driver;

import day4.models.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JavaEight {

    public static void main(String[] args) {
        Drawable drawable = () -> {
            System.out.println("Drawing");
        };

        drawable.draw();

        SayBye sayBye = () -> {
            System.out.println("Bye");
        };

        sayBye.sayBye();
        sayBye.sayGm();
        sayBye.sayHello();

        // stream api
        List<Integer> integerList = new ArrayList<>(Arrays.asList(1,12,13,10,5));
        System.out.println();

        //
        Employee emp = new Employee();
        emp.setSsn(214);
        System.out.println(emp.getSsn());
        doSomething(emp);
        System.out.println(emp.getSsn());
    }

    public static Employee doSomething(final Employee employee){
        Employee emp = new Employee();
//        employee = emp;
        employee.setSsn(142325);

        System.out.println(employee.getSsn());

        return employee;
    }

    public void doSom(){

    }

}

interface Drawable{
    public void draw();
}

@FunctionalInterface
interface SayBye{
    void sayBye();

    default public void sayHello(){
        System.out.println("Hello");
    }

    default public void sayGm(){
        System.out.println("Good morning");
    }
}
