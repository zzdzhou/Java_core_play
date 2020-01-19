package jack.javacore.thread.sharingresources;

public class EvenGenerator extends IntGenerator {

    private int currentValue = 0;

    @Override
    public synchronized int next() {
        ++ currentValue; //danger point here
        Thread.yield(); //cause failure faster
        ++ currentValue;
        return currentValue;
    }

    public static void main(String[] args) {
        EvenChecker.test(new EvenGenerator());
    }

}
