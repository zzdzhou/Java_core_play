package jack.javacore.thread.sharingresources;

public abstract class IntGenerator {

    private volatile boolean cancelled = false;

    public abstract int next();

    public void cancel() {
        cancelled = true;
    }

    public boolean isCancelled() {
        return this.cancelled;
    }
}
