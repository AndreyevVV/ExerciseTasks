package LeetCode.Concurrency.Medium.Building_H2O.SynchronizedMethod_solution;

public class H2O {
    private int count;

    public H2O() {
        this.count = 0;
    }

    public synchronized void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        while (count == 2) {
            wait();
        }
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        count++;
        notifyAll();
    }

    public synchronized void oxygen(Runnable releaseOxygen) throws InterruptedException {
        while (count < 2) {
            wait();
        }
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        releaseOxygen.run();
        count = 0;
        notify();
    }
}
