package jack.javacore.concurrent.sharedresource.threadlocal;

import javax.sound.midi.Soundbank;
import java.util.Random;

public class Accessor implements Runnable {
    private final int id;

    public Accessor(int idn) {
        this.id = idn;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            ThreadLocalVariableHolder.increment();
            System.out.println("/" + this);
            Thread.yield();
        }

    }

    @Override
    public String toString() {
        return "#" + id + ": " + ThreadLocalVariableHolder.get();
    }

    /*public static void main(String[] args) {
        Random random = new Random(5);
        for (int i = 0; i < 4; i++) {
            System.out.println(random.nextInt(23));
        }

    }*/
}
