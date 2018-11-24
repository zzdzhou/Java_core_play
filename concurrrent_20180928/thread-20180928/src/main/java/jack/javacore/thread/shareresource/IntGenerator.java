package jack.javacore.thread.shareresource;

import jack.javacore.thread.BaseThreads;

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
