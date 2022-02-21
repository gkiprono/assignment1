package java_basic.day2.model;

/*
* Author: Kiprono
* Purpose: simple Parent class Student
*
* */


abstract class Student implements Comparable<Student>{
    private int age;
    private String firstName;
    private String lastName;

    public Student(int age, String firstName, String lastName) {
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Student() {

    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "First Name: " + this.firstName + ", Last Name: "  + this.lastName + ", Age: "  + this.age;
    }

}
