package day4.driver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class JavaOptional {

    public static void main(String[] args) {
        String str = null;

        if (str == null){
            System.out.println("empty string");
        }else{
            System.out.println(str);
        }

        Optional<String> optionalS = Optional.ofNullable(str);
        System.out.println(optionalS.orElse("nothing here"));


    }
}
