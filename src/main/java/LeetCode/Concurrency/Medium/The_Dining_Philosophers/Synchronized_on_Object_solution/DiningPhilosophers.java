package LeetCode.Concurrency.Medium.The_Dining_Philosophers.Synchronized_on_Object_solution;

public class DiningPhilosophers {

    private Object lock;

    public DiningPhilosophers() {
        this.lock = new Object();
    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {

        synchronized (lock) {
            pickLeftFork.run();
            pickRightFork.run();
            eat.run();
            putLeftFork.run();
            putRightFork.run();
        }
    }
}
