package LeetCode.Concurrency.Medium.Fizz_Buzz_Multithreaded.SynchronizedMethod_solution;

import java.util.function.IntConsumer;

public class FizzBuzz {

    private int n;
    private int i;

    public FizzBuzz(int n) {
        this.n = n;
        this.i = 1;
    }

    // printFizz.run() outputs "fizz".
    synchronized public void fizz(Runnable printFizz) throws InterruptedException {
        while (i <= n) {
            if (i % 3 == 0 && i % 5 != 0) {
                i++;
                printFizz.run();
                notifyAll();
            } else {
                wait();
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    synchronized public void buzz(Runnable printBuzz) throws InterruptedException {
        while (i <= n) {
            if (i % 5 == 0 && i % 3 != 0) {
                printBuzz.run();
                i++;
                notifyAll();
            } else {
                wait();
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    synchronized public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (i <= n) {
            if (i % 15 == 0) {
                printFizzBuzz.run();
                i++;
                notifyAll();
            } else {
                wait();
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    synchronized public void number(IntConsumer printNumber) throws InterruptedException {
        while (i <= n) {
            if (i % 3 == 0 || i % 5 == 0) {
                wait();
            } else {
                printNumber.accept(i);
                i++;
                notifyAll();
            }
        }
    }
}
