package LeetCode.Concurrency.Easy.Print_in_Order.Synchronized_on_Object_solution;

public class Foo {
    private Object lock;
    private boolean firstCondition;
    private boolean secondCondition;

    public Foo() {
        lock = new Object();
        firstCondition = false;
        secondCondition = false;
    }

    public void first(Runnable printFirst) throws InterruptedException {
        synchronized (lock) {
            printFirst.run();
            firstCondition = true;
            lock.notifyAll();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (lock) {
            while (!firstCondition) {
                lock.wait();
            }
            printSecond.run();
            secondCondition = true;
            lock.notifyAll();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (lock) {
            while (!secondCondition) {
                lock.wait();
            }
            printThird.run();
        }
    }
}
