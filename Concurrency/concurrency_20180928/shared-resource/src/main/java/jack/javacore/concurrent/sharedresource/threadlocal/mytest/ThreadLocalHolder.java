package jack.javacore.concurrent.sharedresource.threadlocal.mytest;

public class ThreadLocalHolder {

    public static ThreadLocal<String> value = ThreadLocal.withInitial(() -> "default value");


}
