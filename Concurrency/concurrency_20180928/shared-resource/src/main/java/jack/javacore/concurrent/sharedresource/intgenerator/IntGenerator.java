package jack.javacore.concurrent.sharedresource.intgenerator;

public abstract class IntGenerator {

    private volatile boolean canceled = false;

    public abstract int next();

    public void cancel() {
//        System.out.println("log cancel()");
        this.canceled = true;
    }

    public boolean isCanceled() {
        return this.canceled;
    }

}
