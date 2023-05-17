package LeetCode.Concurrency.Easy.Print_in_Order;

import LeetCode.Concurrency.Easy.Print_in_Order.CountDownLatch_solution.Foo;
//import LeetCode.Concurrency.Easy.Print_in_Order.Semaphore.Foo;
//import LeetCode.Concurrency.Easy.Print_in_Order.SynchronizedMethod_solution.Foo;
//import LeetCode.Concurrency.Easy.Print_in_Order.Synchronized_on_Object_solution.Foo;
//import LeetCode.Concurrency.Easy.Print_in_Order.Volatile_solution.Foo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Foo foo = new Foo();

        Runnable printFirst = () -> System.out.println("first");
        Runnable printSecond = () -> System.out.println("second");
        Runnable printThird = () -> System.out.println("third");

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        try {
            executorService.execute(() -> {
                try {
                    foo.first(printFirst);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            executorService.execute(() -> {
                try {
                    foo.second(printSecond);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            executorService.execute(() -> {
                try {
                    foo.third(printThird);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        } finally {
            executorService.shutdown();
        }
    }
}
