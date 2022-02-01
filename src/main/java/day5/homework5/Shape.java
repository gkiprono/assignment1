package day5.homework5;


import java.util.concurrent.locks.ReentrantLock;

/* Shape class to demonstrate synchronization
* to calculate circumference, we need diameter, diameter is twice radius
*
* */
public class Shape{
    private int radius;
    private int diameter;
    private String name;
    private double area;
    private double circumference;



    public Shape(int radius, String name) {
        this.radius = radius;
        this.name = name;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getDiameter() {
        return diameter;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }

    public String getShapeName() {
        return name;
    }

    public void setShapeName(String name) {
        this.name = name;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getCircumference() {
        return circumference;
    }

    public void setCircumference(double circumference) {
        this.circumference = circumference;
    }

//    // pi * radius squared
//    public double calculateArea(int radius){
//        return Math.PI * radius * radius;
//    }
//
//    // pi * diameter
//    public double calculateCircumference(int diameter){
//        return diameter * Math.PI;
//    }


}
