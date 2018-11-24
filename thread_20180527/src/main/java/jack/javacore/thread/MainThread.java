package jack.javacore.thread;

public class MainThread {

    public static void main(String[] args) {
        LiftOff launch = new LiftOff();
        launch.run(); /*Runnable的run方法并无任何特殊之处，
                        它不会产生任何内在的线程，仅仅是用来表示可以执行的一个任务*/

    }
}
