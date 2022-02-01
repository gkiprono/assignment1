package day5.data;

import java.util.concurrent.Callable;

public class ThreadCallable implements Callable {

    @Override
    public Integer call() throws Exception {
        System.out.println("Extends thread class, the current thread is " + Thread.currentThread().getName());

        return 200;
    }
}
