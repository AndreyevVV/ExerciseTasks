package LeetCode.Concurrency.Easy.Print_in_Order.CountDownLatch_solution;

import java.util.concurrent.CountDownLatch;

public class Foo {
    private CountDownLatch firstLatch;
    private CountDownLatch secondLatch;

    public Foo() {
        firstLatch = new CountDownLatch(1);
        secondLatch = new CountDownLatch(1);
    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        firstLatch.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        firstLatch.await();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        secondLatch.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {
        secondLatch.await();
        // printThird.run() outputs "third".s Do not change or remove this line.
        printThird.run();
    }
}
