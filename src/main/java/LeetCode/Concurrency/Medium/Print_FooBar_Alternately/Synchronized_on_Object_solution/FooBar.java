package LeetCode.Concurrency.Medium.Print_FooBar_Alternately.Synchronized_on_Object_solution;

public class FooBar {
    private final Object lock;
    private int n;
    private boolean flag;

    public FooBar(int n) {
        lock = new Object();
        this.n = n;
        flag = false;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        synchronized (lock) {
            for (int i = 0; i < n; i++) {
                while (flag) {
                    lock.wait();
                }
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                flag = true;
                lock.notify();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        synchronized (lock) {
            for (int i = 0; i < n; i++) {
                while (!flag) {
                    lock.wait();
                }
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                flag = false;
                lock.notify();
            }
        }
    }
}
