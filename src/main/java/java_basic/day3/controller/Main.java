package java_basic.day3.controller;

import day3.models.*;
import day3.models.Sedans;
import day3.models.StaticFruit;

public class Main {

    public static void main(String[] args) {
        StaticFruit.eatApple();
        System.out.println(StaticFruit.getFruitName());

        System.out.println(divisionByZero(2,1));

        Sedans auto = new Sedans(4,"Toyota");
        System.out.println(auto.toString());


    }

    public static int divisionByZero(int a, int b){
        int result = 0;
        try {
            result = a/b;
        }catch (ArithmeticException ex){
            System.out.println("Error! Division by Zero");
        } finally {
            return result;
        }
    }
}
