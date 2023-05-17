package LeetCode.Concurrency.Medium.Fizz_Buzz_Multithreaded.Synchronized_on_Object_solution;

import java.util.function.IntConsumer;

public class FizzBuzz {
    private Object lock;
    private int n;
    private int i;

    public FizzBuzz(int n) {
        lock = new Object();
        this.n = n;
        this.i = 1;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        synchronized (lock) {
            while (i<=n) {
                if (i%3==0 && i%5!=0) {
                    printFizz.run();
                    i+=1;
                    lock.notifyAll();
                } else {
                    lock.wait();
                }
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        synchronized (lock) {
            while (i<=n) {
                if (i%3!=0 && i%5==0) {
                    printBuzz.run();
                    i+=1;
                    lock.notifyAll();
                } else {
                    lock.wait();
                }
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        synchronized (lock) {
            while (i<=n) {
                if (i%15==0) {
                    printFizzBuzz.run();
                    i+=1;
                    lock.notifyAll();
                } else {
                    lock.wait();
                }
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        synchronized (lock) {
            while (i<=n) {
                if (i%3!=0 && i%5!=0) {
                    printNumber.accept(i);
                    i+=1;
                    lock.notifyAll();
                } else {
                    lock.wait();
                }
            }
        }
    }
}
