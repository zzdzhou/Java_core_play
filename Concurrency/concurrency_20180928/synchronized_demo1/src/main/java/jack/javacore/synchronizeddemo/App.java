package jack.javacore.synchronizeddemo;

public class App {

    private static int i = 0;

    private void taskThread() {
        new Thread(() -> {
            synchronized (this) {
                while (i < 100) {
                    System.out.println(Thread.currentThread().getName() + " " + ++i);
                    notify();
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }


    public static void main(String[] args) {
        App app = new App();
        app.taskThread();
        app.taskThread();
    }

}
