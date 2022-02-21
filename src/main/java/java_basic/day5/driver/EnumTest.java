package java_basic.day5.driver;

import day5.data.Color;
import java_basic.day5.data.Color;

import java.util.Arrays;

enum Ecolor{
    Red(3), Blue(2),Black(1);

    int value;
    Ecolor(int val){
        this.value = val;
    }

}


public class EnumTest {
    public static void main(String[] args) {
        System.out.println(Color.Red);
        System.out.println(Ecolor.Red.ordinal());
        System.out.println(Ecolor.Red);
        Arrays.stream(Ecolor.values()).forEach(System.out::println);
    }
}
