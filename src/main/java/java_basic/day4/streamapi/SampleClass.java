package java_basic.day4.streamapi;

public class SampleClass {

    private String name;
    private int age;
    private int ssn;

    public SampleClass(String name, int age, int ssn) {
        this.name = name;
        this.age = age;
        this.ssn = ssn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSsn() {
        return ssn;
    }

    public void setSsn(int ssn) {
        this.ssn = ssn;
    }

    @Override
    public String toString() {
        return new String("Name: " + this.name + " Age: " + this.age + " SSN: " + this.ssn);
    }
}
