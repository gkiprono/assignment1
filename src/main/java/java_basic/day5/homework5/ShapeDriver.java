package java_basic.day5.homework5;

/* Demonstrate locks and unlock features
* to calculate circumference, we need diameter, diameter is twice radius, implementing threads and lock
* First, lock and calculate area and diameter, then release
* */


import java.util.concurrent.locks.ReentrantLock;

public class ShapeDriver implements Runnable{
    private ReentrantLock reentrantLock;
    String name;
    private Shape circle;

    public ShapeDriver(ReentrantLock reentrantLock, String name, Shape shape) {
        this.reentrantLock = reentrantLock;
        this.name = name;
        this.circle = shape;
    }

    // pi * radius squared
    public double calculateArea(int radius){
        return Math.PI * radius * radius;
    }

    // pi * diameter
    public double calculateCircumference(int diameter){
        return diameter * Math.PI;
    }

    @Override
    public void run() {
        boolean done = false;
        boolean ans;

        // calculate diameter, area and
        while (!done){
            // getting the outer lock
            ans = reentrantLock.tryLock(); // true if lock is free

            if(ans){
                try{
                    // calculate area and diameter
                    System.out.println(name + "Task: Calculating the area and diameter");
                    circle.setDiameter(circle.getRadius() * 2);
                    circle.setArea(this.calculateArea(circle.getRadius()));
                    System.out.println("Cirrcles area is: " + circle.getArea() + " with radius " + circle.getRadius());
                    Thread.sleep(1500);

                    reentrantLock.lock();
                    try{
                        // inner lock, calculate circumference
                        circle.setCircumference(this.calculateCircumference(circle.getDiameter()));
                        System.out.println("Circles circumference is: " + circle.getCircumference() + " with diameter " + circle.getDiameter());
                        Thread.sleep(1500);
                    }catch (InterruptedException ex){
                        ex.printStackTrace();
                    } finally {
                        // release the lock
                        System.out.println( name + "Task: Releasing lock after calculating area and diameter");
                        reentrantLock.unlock();
                    }
                    System.out.println(name  + "Area-Diameter calculation done");
                    System.out.println("lock hold count " + reentrantLock.getHoldCount());
                    done = true;
                }catch (InterruptedException e){
                    e.printStackTrace();
                } finally {
                    System.out.println(name + " releasing lock");
                    reentrantLock.unlock();
                    System.out.println("lock hold count " + reentrantLock.getHoldCount());
                }
            }else{
                System.out.println("Task "+ name + " is waiting for lock");
                System.out.println("Total of " + reentrantLock.getQueueLength() + " threads waiting for lock");
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }

        }
    }
}

