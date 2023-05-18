package LeetCode.Concurrency.Medium.Print_Zero_Even_Odd.Synchronized_on_Object_solution;

import java.util.function.IntConsumer;

public class ZeroEvenOdd {
    private Object lock;
    private int n;
    private int state = 0;

    public ZeroEvenOdd(int n) {
        lock = new Object();
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        synchronized (lock) {
            for (int i = 0; i < n; i++) {
                while (state != 0) {
                    lock.wait();
                }

                printNumber.accept(0);

                state = i % 2 == 0 ? 1 : 2;
                lock.notifyAll();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        synchronized (lock) {
            for (int i = 2; i <= n; i += 2) {
                while (state != 2) {
                    lock.wait();
                }

                printNumber.accept(i);

                state = 0;
                lock.notifyAll();
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        synchronized (lock) {
            for (int i = 1; i <= n; i += 2) {
                while (state != 1) {
                    lock.wait();
                }

                printNumber.accept(i);

                state = 0;
                lock.notifyAll();
            }
        }
    }
}
