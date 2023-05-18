package LeetCode.Concurrency.Medium.Print_Zero_Even_Odd;

import LeetCode.Concurrency.Medium.Print_Zero_Even_Odd.Semaphore_solution.ZeroEvenOdd;
//import LeetCode.Concurrency.Medium.Print_Zero_Even_Odd.Synchronized_on_Object_solution.ZeroEvenOdd;

import java.util.function.IntConsumer;

public class Main {
    public static void main(String[] args) {
        int n = 10; // Задайте нужное значение n

        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(n);

        IntConsumer printNumber = System.out::print; // Реализация функции printNumber, которая просто выводит число в консоль

        Thread threadA = new Thread(() -> {
            try {
                zeroEvenOdd.zero(printNumber);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread threadB = new Thread(() -> {
            try {
                zeroEvenOdd.even(printNumber);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread threadC = new Thread(() -> {
            try {
                zeroEvenOdd.odd(printNumber);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        threadA.start();
        threadB.start();
        threadC.start();

        try {
            threadA.join();
            threadB.join();
            threadC.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
