package day5.data;

public class ThreadRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println("Extends thread class, the current thread is " + Thread.currentThread().getName());
    }
}
