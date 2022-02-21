package java_basic.day5.driver;

import day5.data.ThreadCallable;
import day5.data.ThreadExtend;
import day5.data.ThreadRunnable;
import java_basic.day5.data.ThreadExtend;
import java_basic.day5.data.ThreadRunnable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadDriver {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Thread threadExtend = new ThreadExtend();
        threadExtend.start();

        Thread threadRunnable = new Thread(new ThreadRunnable());
        threadRunnable.start();

        FutureTask task = new FutureTask(new ThreadCallable());
        Thread thread = new Thread(task);
        thread.start();
        System.out.println(task.get());
    }
}
