package LeetCode.Concurrency.Medium.Print_Zero_Even_Odd;

import LeetCode.Concurrency.Medium.Print_Zero_Even_Odd.Semaphore_solution.ZeroEvenOdd;
//import LeetCode.Concurrency.Medium.Print_Zero_Even_Odd.Synchronized_on_Object_solution.ZeroEvenOdd;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;

public class Main {
    public static void main(String[] args) {
        int n = 10;

        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(n);

        IntConsumer printNumber = System.out::print;

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        AtomicInteger count = new AtomicInteger(0);

        executorService.execute(() -> {
            try {
                zeroEvenOdd.zero(number -> {
                    if (count.incrementAndGet() <= 2 * n) {
                        printNumber.accept(number);
                    }
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executorService.execute(() -> {
            try {
                zeroEvenOdd.even(number -> {
                    if (count.incrementAndGet() <= 2 * n) {
                        printNumber.accept(number);
                    }
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executorService.execute(() -> {
            try {
                zeroEvenOdd.odd(number -> {
                    if (count.incrementAndGet() <= 2 * n) {
                        printNumber.accept(number);
                    }
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executorService.shutdown();

        try {
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
