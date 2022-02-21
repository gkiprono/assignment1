#### January 31, 2022

*Author: Gabriel Kiprono*

---

# Multithreading in Java

## Homework 5.1
### Lock mechanism & synchronization
###  Synchronization
1. ##### Synchronized instance methods
    Achieved by adding synchronized keyword in the method declaration.
    ```java
   public class Sample{
        public synchronized void synchronisedCalculate(){
            setSum(getSum()+1);
        }    
   } 
   ```
   nb: Instance methods are synchronized over the instance of the class owning the method, meaning only one thread
    thread per instance of the class can execute this method.
2. ##### Synchronized static methods
    similar to above except the method is static
    ```java
   public class Sample{
        public static synchronized void synchronisedCalculate(){
            setSum(getSum()+1);
        }    
   } 
   
   ```
   Also, only one thread can execute inside a static synchronized method per class. 
3. ##### Synchronized blocks within the method
    Entire method is not synchronized
    ```java
    public class Sample{
        public void synchronisedCalculate(){
            synchronized(this){
                setCount(getCount()+1);
            }
        }    
   } 
    ```
   nb: the code inside the synchronized get synchronized on the calling object. Only one thread per object execute this code
4. ##### Synchronized Class
   synchronized keyword is used in class 
    
    ```java
    public class SynchronizedClass{
        private int age;
        private String name;
        
        public SynchronizedClass(int age, String name){
            this.age = age;
            this.name = name;
        }    
        
        public synchronized int getAge(){
            return this.age;
        }
   
        public synchronized String getName(){
            return this.name;
        }
   }
    ```

### Locks
The Java Lock Interface represent a concurrent lock which can be used to guard against race conditions inside 
critical sections.

#### Lock and reentrantlock methods 
##### Lock interface methods
- lock() - locks the lock instance if acquired
- tryLock() - attempts to lock the lock instance immediatelyif it is available. returns true if lock was successful
- trylock(timeout, timeUnit) - works like above trylock() but locks for specified amount of time.
- unlock() - unlocks the lock instance. method that locked the lock instance is responsible for unlocking it.
- lockInterruptibly() - this method locks the lock unless the thread calling the method has been interrupted.

##### Reentrant lock methods

- getHoldCount() - returns the number of time a given thread has locked this lock instance.
- isLocked() - returns true if the lock is currently locked, else false.
- isHeldByCurrentThread() - returns true if lock is locked by the thread calling it.
- hasQueuedThreads() - returns true if any threads are queued up waiting to lock this lock.
- hasQueuedThread(Thread) - returns true if the passed thread is queued up waiting to lock the lock.
- getQueueLength() - returns the number of threads waiting to lock the lock.
- isFair() - returns true if this lock guarantees fairness among threads waiting to lock it.

### Future and CompletableFuture
#### Future
They are placeholders for a result of an operation that hasn't finished yet. Example below,

```java
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureDemo implements Callable<Integer> {
   @Override
   public Integer call() throws Exception {
      Thread.sleep(1000);
      return 1;
   }


   public static void main(String[] args) throws ExecutionException, InterruptedException {
      ExecutorService executorService = Executors.newSingleThreadExecutor();
      Future<Integer> futureInteger = executorService.submit(new FutureDemo());

      System.out.println(futureInteger.get()); // waits for 1000ms till FutureDemo task is done,
   }
}
```

#### Completable future
This feature allows you to string tasks together in a chain. In more context, do x when you are done, go do Y with the 
results from x.

```java
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.function.Function;
import java.util.concurrent.Executors;
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

   public static class AddFive implements Function<Integer, Integer> {
      @Override
      public Integer apply(Integer x) {
         return x + 5;
      }
   }

   public static void main(String[] args) throws Exception {
      ExecutorService executorService = Executors.newSingleThreadExecutor();
      CompletableFuture<Integer> integerCompletableFuture = CompletableFuture.supplyAsync(new CompletableFutureDemo(), executorService);

      System.out.println("Still processing? " + !integerCompletableFuture.isDone());
      CompletableFuture<Integer> integerCompletableFuture1 = integerCompletableFuture.thenApply(new AddFive());

      System.out.println(integerCompletableFuture1.get()); // six
   }
}
```
