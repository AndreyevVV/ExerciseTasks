package LeetCode.Concurrency.Medium.The_Dining_Philosophers.Locks_with_Condirion_solution;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DiningPhilosophers {

    private Lock[] forks;
    private Condition[] forkAvailable;

    public DiningPhilosophers() {
        forks = new Lock[5];
        forkAvailable = new Condition[5];
        for (int i = 0; i < 5; i++) {
            forks[i] = new ReentrantLock();
            forkAvailable[i] = forks[i].newCondition();
        }
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

        forks[leftFork].lock();
        try {
            while (!forks[rightFork].tryLock()) {
                forkAvailable[leftFork].await();
            }

            pickLeftFork.run();
            pickRightFork.run();

            eat.run();

            putLeftFork.run();
            putRightFork.run();

            forks[rightFork].unlock();
            forkAvailable[rightFork].signal();
        } finally {
            forks[leftFork].unlock();
        }
    }
}
