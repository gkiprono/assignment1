package day2.model;

/*
 * Author: Kiprono
 * Purpose: Implement comparable
 *
 * */


public class StudentCompareTo extends Student implements Comparable<Student>{

    public StudentCompareTo(int age, String firstName, String lastName) {
        super(age, firstName, lastName);
    }

    public StudentCompareTo() {
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
    public int compareTo(Student o) {
        if(this.getAge() == o.getAge()){
            return 0;
        }
        return this.getAge() < o.getAge() ? -2:3;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
