package LeetCode.Concurrency.Easy.Print_in_Order.SynchronizedMethod_solution;

public class Foo {
    private boolean firstCondition;
    private boolean secondCondition;

    public Foo() {
        firstCondition = false;
        secondCondition = false;
    }

    public synchronized void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        firstCondition = true;
        notifyAll();
    }

    public synchronized void second(Runnable printSecond) throws InterruptedException {
        while (!firstCondition) {
            wait();
        }
        printSecond.run();
        secondCondition = true;
        notifyAll();
    }

    public synchronized void third(Runnable printThird) throws InterruptedException {
        while (!secondCondition) {
            wait();
        }
        printThird.run();
    }
}
