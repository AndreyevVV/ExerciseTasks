package LeetCode.Concurrency.Medium.The_Dining_Philosophers.Semaphore_plus_ReentrantLock_solution;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DiningPhilosophers {

    private Semaphore[] forks;
    private Lock pickForkLock;

    public DiningPhilosophers() {
        forks = new Semaphore[5];
        for (int i = 0; i < 5; i++) {
            forks[i] = new Semaphore(1);
        }
        pickForkLock = new ReentrantLock();
    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        int leftFork = philosopher;
        int rightFork = (philosopher + 1) % 5;

        pickForkLock.lock();

        forks[leftFork].acquire();
        forks[rightFork].acquire();

        pickLeftFork.run();
        pickRightFork.run();

        eat.run();

        putLeftFork.run();
        forks[leftFork].release();

        putRightFork.run();
        forks[rightFork].release();

        pickForkLock.unlock();
    }
}
