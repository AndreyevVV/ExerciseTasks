package LeetCode.Concurrency.Medium.Building_H2O.Synchronized_on_Object_solution;

public class H2O {
    final Object lock;
    private int count;

    public H2O() {
        lock = new Object();
        this.count = 0;
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        synchronized (lock) {
            while (count == 2) {
                lock.wait();
            }
            // releaseHydrogen.run() outputs "H". Do not change or remove this line.
            releaseHydrogen.run();
            count++;
            lock.notifyAll();
        }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        synchronized (lock) {
            while (count < 2) {
                lock.wait();
            }
            // releaseOxygen.run() outputs "O". Do not change or remove this line.
            releaseOxygen.run();
            count = 0;
            lock.notify();
        }
    }
}
