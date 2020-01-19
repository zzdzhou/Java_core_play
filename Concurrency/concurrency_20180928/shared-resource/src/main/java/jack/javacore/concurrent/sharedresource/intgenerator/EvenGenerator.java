package jack.javacore.concurrent.sharedresource.intgenerator;

import jack.javacore.concurrent.sharedresource.EvenChecker;

public class EvenGenerator extends IntGenerator {

    private int currentEvenValue = 0;

    @Override
    public int next() {
        ++currentEvenValue;  // danger point here
        Thread.yield();
        ++currentEvenValue;
        return currentEvenValue;
    }

    public static void main(String[] args) {
        EvenChecker.test(new EvenGenerator());
    }

}
