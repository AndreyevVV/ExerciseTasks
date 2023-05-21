package LeetCode.Concurrency.Medium.The_Dining_Philosophers;

import LeetCode.Concurrency.Medium.The_Dining_Philosophers.Semaphore_plus_ReentrantLock_solution.DiningPhilosophers;
//import LeetCode.Concurrency.Medium.The_Dining_Philosophers.Synchronized_on_Object_solution.DiningPhilosophers;
//import LeetCode.Concurrency.Medium.The_Dining_Philosophers.Locks_with_Condirion_solution.DiningPhilosophers;

public class Main {

    public static void main(String[] args) {

        DiningPhilosophers philosophers = new DiningPhilosophers();

        Thread[] threads = new Thread[5];

        for (int i = 0; i < 5; i++) {
            final int philosopherId = i;
            threads[i] = new Thread(() -> {
                try {
                    while (true) {
                        philosophers.wantsToEat(
                                philosopherId,
                                () -> System.out.println("Philosopher " + philosopherId + " picks left fork"),
                                () -> System.out.println("Philosopher " + philosopherId + " picks right fork"),
                                () -> System.out.println("Philosopher " + philosopherId + " eats"),
                                () -> System.out.println("Philosopher " + philosopherId + " puts left fork"),
                                () -> System.out.println("Philosopher " + philosopherId + " puts right fork")
                        );
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            threads[i].start();
        }

        for (int i = 0; i < 5; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
