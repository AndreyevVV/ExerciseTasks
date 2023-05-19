package LeetCode.Concurrency.Medium.Print_FooBar_Alternately;

import LeetCode.Concurrency.Medium.Print_FooBar_Alternately.Semaphore_solution.FooBar;
//import LeetCode.Concurrency.Medium.Print_FooBar_Alternately.Synchronized_on_Object_solution.FooBar;

public class Main {
    private static void testFizzBuzz() {
        int n = 5;

        FooBar foobar = new FooBar(n);

        Thread threadA = new Thread(() -> {
            try {
                foobar.foo(() -> System.out.print("foo"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread threadB = new Thread(() -> {
            try {
                foobar.bar(() -> System.out.print("bar"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        threadA.start();
        threadB.start();

        try {
            threadA.join();
            threadB.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
