package model;

import java.util.Comparator;

/*
 * Author: Kiprono
 * Purpose: Implement Comparator
 *
 * */

public class StudentCompare extends Student implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return o2.getAge() - o1.getAge();
    }

    public StudentCompare(int age, String firstName, String lastName) {
        super(age, firstName, lastName);
    }

    public StudentCompare() {
        super();
    }

    @Override
    public int getAge() {
        return super.getAge();
    }

    @Override
    public void setAge(int age) {
        super.setAge(age);
    }

    @Override
    public String getFirstName() {
        return super.getFirstName();
    }

    @Override
    public void setFirstName(String firstName) {
        super.setFirstName(firstName);
    }

    @Override
    public String getLastName() {
        return super.getLastName();
    }

    @Override
    public void setLastName(String lastName) {
        super.setLastName(lastName);
    }

    @Override
    public String toString() {
        return super.toString();
    }


    @Override
    public int compareTo(Student o) {
        if(this.getAge() == o.getAge()){
            return 0;
        }
        return this.getAge() < o.getAge() ? -2:3;
    }
}
