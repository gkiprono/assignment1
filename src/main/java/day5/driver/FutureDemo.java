package day5.driver;

import java.util.concurrent.*;

public class FutureDemo implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("Wait for 1000ms");
        Thread.sleep(1000);
        return 1;
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Integer> futureInteger = executorService.submit(new FutureDemo());

        System.out.println(futureInteger.get()); // waits for 1000ms till FutureDemo task is done,
//        Thread.dumpStack();
    }

}