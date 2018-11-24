package jack.java8.completablefuture;

import java.util.concurrent.*;

/**
 * Theme:
 * <p>11.1 Future 接口
 *
 * Description:
 *
 * @author Java 8 实战.pdf
 * Created on 2018-10-21
 */
public class FutureDemo {


    public void futureDemo() {
        ExecutorService exec = Executors.newCachedThreadPool();
        // 向ExecutorService提交一个Callable对象
        // 以异步方式在新的线程中执行耗时的操作
        Future<Long> result = exec.submit(this::doSomeLongComputation);
        // 在Future对象完成之前超过已过期，你可以做其他的事情
        doSomethingElse();
        try {
            // 获取异步操作的结果， 如果最终被阻塞， 无法得到结果， 那么在最多等待5秒钟之后退出
            Long l = result.get(5_000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            // 当前线程在等待过程中被中断
        } catch (ExecutionException e) {
            // 计算抛出一个异常
        } catch (TimeoutException e) {
            // 在Future对象完成之前超时已过期
        }
    }

    private Long doSomeLongComputation() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 0L;
    }

    private void doSomethingElse() {

    }


}
