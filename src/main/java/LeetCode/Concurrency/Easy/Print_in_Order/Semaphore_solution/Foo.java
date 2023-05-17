package LeetCode.Concurrency.Easy.Print_in_Order.Semaphore_solution;

import java.util.concurrent.Semaphore;

public class Foo {
    private Semaphore semaphore;
    private Semaphore semaphore1;

    public Foo() {
        semaphore = new Semaphore(0);
        semaphore1 = new Semaphore(0);
    }

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        semaphore.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        semaphore.acquire();
        printSecond.run();
        semaphore1.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        semaphore1.acquire();
        printThird.run();
    }
}
