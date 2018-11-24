package jack.javacore.thread.sharingresources;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EvenChecker implements Runnable {

    private IntGenerator generator;

    private final int id;

    public EvenChecker(IntGenerator generator, int id) {
        this.generator = generator;
        this.id = id;
    }

    @Override
    public void run() {
        while (!generator.isCancelled()) {
            int val = generator.next();
            if (val % 2 != 0) {
                System.out.println(val + " is not even");
                generator.cancel();
            }
        }
    }

    public static void test(IntGenerator generator, int count) {
        System.out.println("Print Ctrl+C to exit");
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < count; i++) {
            exec.execute(new EvenChecker(generator, i));
        }
        exec.shutdown();
    }

    public static void test(IntGenerator generator) {
        test(generator, 10);
    }
}
