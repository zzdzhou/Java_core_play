package jack.javacore.thread;

public class LiftOff implements Runnable {

    protected int countDown = 10; // default

    private static int taskAccount = 0;

    private final int id = taskAccount++;

    public LiftOff() {
    }

    public LiftOff(int countDown) {
        this.countDown = countDown;
    }

    @Override
    public void run() {
        while (countDown-- > 0) {
            System.out.println(status());
            Thread.yield();
        }
    }

    public String status() {
        return "#" + id + "(" + (countDown > 0? countDown : "Lift off!") + ")";
    }
}
