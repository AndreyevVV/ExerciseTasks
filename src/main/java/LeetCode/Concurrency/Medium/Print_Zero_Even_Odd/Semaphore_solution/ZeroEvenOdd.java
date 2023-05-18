package LeetCode.Concurrency.Medium.Print_Zero_Even_Odd.Semaphore_solution;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class ZeroEvenOdd {
    private int n;
    Semaphore s0 = new Semaphore(1);
    Semaphore sOdd = new Semaphore(0);
    Semaphore sEven = new Semaphore(0);


    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            s0.acquire();

            printNumber.accept(0);

            if ((i & 1) == 0) {
                sEven.release();
            } else sOdd.release();
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            sEven.acquire();

            printNumber.accept(i);

            s0.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            sOdd.acquire();

            printNumber.accept(i);

            s0.release();
        }
    }
}
