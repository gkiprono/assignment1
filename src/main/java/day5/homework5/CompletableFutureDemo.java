package day5.homework5;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Function;
import java.util.function.Supplier;

public class CompletableFutureDemo implements Supplier<Integer> {
    @Override
    public Integer get() {
        try {
            Thread.sleep(1000);

        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } finally {
            return 1;
        }
    }

    // adds 5 to future value of applier
    public static class AddFive implements Function<Integer, Integer> {
        @Override
        public Integer apply(Integer x) {
            return x + 5;
        }
    }

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        CompletableFuture<Integer> integerCompletableFuture = CompletableFuture.supplyAsync(new CompletableFutureDemo(), executorService);

        System.out.println("Still processing? " + !integerCompletableFuture.isDone()); // true
        CompletableFuture<Integer> integerCompletableFuture1 = integerCompletableFuture.thenApply(new AddFive());

        System.out.println(integerCompletableFuture1.get()); // six
    }
}
