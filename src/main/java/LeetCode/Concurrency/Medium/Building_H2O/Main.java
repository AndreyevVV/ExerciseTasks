package LeetCode.Concurrency.Medium.Building_H2O;

import LeetCode.Concurrency.Medium.Building_H2O.SynchronizedMethod_solution.H2O;
//import LeetCode.Concurrency.Medium.Building_H2O.Synchronized_on_Object_solution.H2O;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        H2O h2o = new H2O();

        Runnable releaseHydrogen = () -> System.out.println("H");
        Runnable releaseOxygen = () -> System.out.println("O");

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        try {
            executorService.execute(() -> {
                try {
                    h2o.hydrogen(releaseHydrogen);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            executorService.execute(() -> {
                try {
                    h2o.hydrogen(releaseHydrogen);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            executorService.execute(() -> {
                try {
                    h2o.oxygen(releaseOxygen);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        } finally {
            executorService.shutdown();
        }
    }
}
