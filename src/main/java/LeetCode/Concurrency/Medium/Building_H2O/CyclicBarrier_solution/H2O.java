package LeetCode.Concurrency.Medium.Building_H2O.CyclicBarrier_solution;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class H2O {

    private Semaphore oxygenSemaphore;
    private Semaphore hydrogenSemaphore;
    private CyclicBarrier barrier;

    public H2O() {
        hydrogenSemaphore = new Semaphore(1);
        oxygenSemaphore = new Semaphore(2);
        barrier = new CyclicBarrier(3);
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        oxygenSemaphore.acquire();
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        try {
            barrier.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        oxygenSemaphore.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        hydrogenSemaphore.acquire();
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        releaseOxygen.run();
        try {
            barrier.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        hydrogenSemaphore.release();
    }
}
