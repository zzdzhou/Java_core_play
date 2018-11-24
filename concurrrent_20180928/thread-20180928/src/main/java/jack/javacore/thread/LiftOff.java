package jack.javacore.thread;

public class LiftOff implements Runnable {
    protected int countdown = 10;
    private static int taskCount = 0;
    private final int id = taskCount++;

    public LiftOff() {
    }

    public LiftOff(int countdown) {
        this.countdown = countdown;
    }

    public String status() {
        return "#" + this.id + "(" + (this.countdown > 0 ? this.countdown : "Lift off!") + "), ";
    }

    @Override
    public void run() {
        while (this.countdown-- > 0) {
            System.out.print(this.status());
            Thread.yield();
        }
        System.out.println();
    }

}
