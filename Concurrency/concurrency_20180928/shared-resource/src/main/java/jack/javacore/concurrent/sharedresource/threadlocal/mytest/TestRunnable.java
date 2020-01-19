package jack.javacore.concurrent.sharedresource.threadlocal.mytest;

public class TestRunnable implements Runnable {

    private int id;

    public TestRunnable(int idn) {
        this.id = idn;
    }

    @Override
    public void run() {
        ThreadLocalVariableHolder1.increment();
        System.out.println("#" + id + " " + ThreadLocalVariableHolder1.value.get());
    }
}
