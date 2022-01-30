package day4.driver;

import day4.generics.Generic;

public class Driver {
    public static void main(String[] args) {
        Generic<Integer, String> generic = new Generic<>();
        Generic<Integer, String> generic1 = new Generic<>(1, "Gabriel");
        Generic<String, Integer> generic3 = new Generic<>("Gabriel", 23);
    }

}
