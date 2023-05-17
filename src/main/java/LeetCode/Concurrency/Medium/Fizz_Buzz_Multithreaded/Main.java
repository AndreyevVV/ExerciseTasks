package LeetCode.Concurrency.Medium.Fizz_Buzz_Multithreaded;

import LeetCode.Concurrency.Medium.Fizz_Buzz_Multithreaded.Synchronized_on_Object_solution.FizzBuzz;
//import LeetCode.Concurrency.Medium.Fizz_Buzz_Multithreaded.SynchronizedMethod_solution.FizzBuzz;

import java.util.function.IntConsumer;

public class Main {
    private static void testFizzBuzz() {

        FizzBuzz fizzBuzz = new FizzBuzz(15);

        Runnable fizz = () -> System.out.print("fizz");
        Runnable buzz = () -> System.out.print("buzz");
        Runnable fBuzz = () -> System.out.print("fizzbuzz");

        IntConsumer number = System.out::print;

        new Thread(() -> {
            try {
                fizzBuzz.fizz(fizz);
            } catch (InterruptedException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }).start();

        new Thread(() -> {
            try {
                fizzBuzz.buzz(buzz);
            } catch (InterruptedException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }).start();

        new Thread(() -> {
            try {
                fizzBuzz.fizzbuzz(fBuzz);
            } catch (InterruptedException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }).start();

        new Thread(() -> {
            try {
                fizzBuzz.number(number);
            } catch (InterruptedException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }).start();
    }
}
