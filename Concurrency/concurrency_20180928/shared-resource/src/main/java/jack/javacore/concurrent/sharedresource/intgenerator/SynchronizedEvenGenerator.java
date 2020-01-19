package jack.javacore.concurrent.sharedresource.intgenerator;

import jack.javacore.concurrent.sharedresource.EvenChecker;

public class SynchronizedEvenGenerator extends IntGenerator {

    private int currentValue = 0;

    @Override
    public synchronized int next() {
        ++currentValue;
//        System.out.println(Thread.currentThread() + " " + currentValue);
        Thread.yield();
        ++currentValue;
        return currentValue;
    }

    public static void main(String[] args) {
        EvenChecker.test(new SynchronizedEvenGenerator());
    }

}
