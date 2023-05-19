package LeetCode.Concurrency.Medium.Print_FooBar_Alternately.ReentrantLock_solution;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class FooBar {
    private int n;
    private ReentrantLock mutex = new ReentrantLock();
    private Condition condition;

    private AtomicBoolean flag;

    public FooBar(int n) {
        this.n = n;
        mutex = new ReentrantLock();
        condition = mutex.newCondition();
        flag = new AtomicBoolean(true);
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            try {
                mutex.lock();
                while (!flag.get()) condition.await();
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                flag.getAndSet(false);
                condition.signalAll();
            } finally {
                mutex.unlock();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        try {
            mutex.lock();
            while (flag.get()) condition.await();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            flag.getAndSet(true);
            condition.signalAll();
        } finally {
            mutex.unlock();
        }
    }
}
