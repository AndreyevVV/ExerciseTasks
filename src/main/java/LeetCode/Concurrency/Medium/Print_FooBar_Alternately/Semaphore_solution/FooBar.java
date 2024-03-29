package LeetCode.Concurrency.Medium.Print_FooBar_Alternately.Semaphore_solution;

import java.util.concurrent.Semaphore;

public class FooBar {
    private int n;
    Semaphore semaphoreFoo;
    Semaphore semaphoreBar;

    public FooBar(int n) {
        this.n = n;
        semaphoreFoo = new Semaphore(1);
        semaphoreBar = new Semaphore(0);
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            semaphoreFoo.acquire();
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            semaphoreBar.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            semaphoreBar.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            semaphoreFoo.release();
        }
    }
}
