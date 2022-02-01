package day5.driver;

import java.util.concurrent.*;

public class ThreadPoolDriver {
    public static void main(String[] args) {
        customThreadPool();

        // other threadpools
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5); // core== 5, max ==5
        ExecutorService singleThreadPool = Executors.newSingleThreadExecutor(); // core 2, max 1
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool(); // core 0, max=Integer.MAXVALUE
        ExecutorService scheduledThreadPoll = Executors.newScheduledThreadPool(3); // create a thread pool that can schedule commands to run after a given delay, or execute periodically
    }

    public static  void customThreadPool(){
        ExecutorService threadPool = new ThreadPoolExecutor(2,
                5,
                2L,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(4),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );

        for (int i=1; i<=10;i++){
            threadPool.execute(
                    () -> {
                        System.out.println(Thread.currentThread().getName() + " dealing with business");
                    }
            );
        }
    }
}
