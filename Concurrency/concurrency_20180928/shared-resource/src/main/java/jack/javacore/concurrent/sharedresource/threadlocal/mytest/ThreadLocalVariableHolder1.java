package jack.javacore.concurrent.sharedresource.threadlocal.mytest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalVariableHolder1 {

    public static ThreadLocal<Integer> value = ThreadLocal.withInitial(() -> 6);

    public static void increment() {
        value.set(value.get() + 1);
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 3; i++) {
            exec.execute(new TestRunnable(i));
        }

    }

}
