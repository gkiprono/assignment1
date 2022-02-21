package java_basic.day3.models;

abstract class AutoMobile {
    private int wheels;
    private String name;

    public AutoMobile(int wheels, String name) {
        this.wheels = wheels;
        this.name = name;
    }

    public AutoMobile() {

    }

    public int getWheels() {
        return wheels;
    }

    public void setWheels(int wheels) {
        this.wheels = wheels;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name + " " + this.wheels;
    }
}
