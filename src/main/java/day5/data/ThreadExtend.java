package day5.data;

/* Thread from extending thread class
*
* */
public class ThreadExtend extends Thread{
    public void run(){
        System.out.println("Extends thread class, the current thread is " + Thread.currentThread().getName());
    }
}
