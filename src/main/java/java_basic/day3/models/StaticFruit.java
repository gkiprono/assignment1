package java_basic.day3.models;

public class StaticFruit {
    private static String fruitName;

    public static void eatApple(){
        System.out.println("I am eating apple");

    }

    static {
        System.out.println("Static block init");
        fruitName = "Apple";
    }

    public static String getFruitName() {
        return fruitName;
    }

    public static void setFruitName(String fruitName) {
        StaticFruit.fruitName = fruitName;
    }
}
