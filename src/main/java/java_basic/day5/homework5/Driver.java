package java_basic.day5.homework5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

/* To test my implementation of locks and threading
*
*
* */


public class Driver {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        ExecutorService pool = Executors.newFixedThreadPool(2);
        // critical section

        Runnable shapeDriver1 = new ShapeDriver(lock, "First", new Shape(3,"Circle A"));
        Runnable shapeDriver2 = new ShapeDriver(lock, "Second",new Shape(7,"Circle B"));
        Runnable shapeDriver3 = new ShapeDriver(lock, "Third", new Shape(5,"Circle C"));
        Runnable shapeDriver4 = new ShapeDriver(lock, "Fourth", new Shape(8,"Circle D"));

        pool.execute(shapeDriver1);
        pool.execute(shapeDriver2);
        pool.execute(shapeDriver3);
        pool.execute(shapeDriver4);

        pool.shutdown();
    }
}
