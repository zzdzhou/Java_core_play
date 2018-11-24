package jack.javacore.thread.shareresource;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EvenChecker implements Runnable {

    private IntGenerator generator;
    private final int id;

    public EvenChecker(IntGenerator g, int ident) {
        this.generator = g;
        this.id = ident;
    }

    @Override
    public void run() {
        while (!generator.isCanceled()) {
            int val = generator.next();
//            System.out.println(Thread.currentThread() + " " + val);
            if (val % 2 != 0) {
                System.out.println(val + " not even!");
                generator.cancel();
            }

        }
    }

    public static void test(IntGenerator gp, int count) {
        System.out.println("Press Ctrl-C to exit");
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exec.execute(new EvenChecker(gp, count));
        }
        exec.shutdown();
    }

    public static void test(IntGenerator gp/* sharing resource*/) {
        test(gp, 10);
    }

}
