package jack.java8.stream.parallel;

import org.junit.Test;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.function.Function;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * Theme:
 * <p> 7.1 并行流
 * 7.2 分支/合并框架
 *
 * Description:
 * 顺序流、并行流 和 分支/合并框架
 *
 * @author Java8 实战.pdf
 * Created on 2018-10-20
 */
public class ParallelStream {

    /**
     * 顺序流求和
     * @param n
     * @return
     */
    public static long sequentialSum(long n) {
        return Stream.iterate(1L, i -> i + 1)
                .limit(n)
                .reduce(0L, Long::sum);
    }

    /**
     * 并行流求和
     * @param n
     * @return
     */
    public static long parallelSum(long n) {
        return Stream.iterate(1L, i -> i + 1)
                .limit(n)
                .parallel()     //将流转换为并行流
                .reduce(0L, Long::sum);
    }

    public static long forkJoinSum(long n) {
        long[] numbers = LongStream.rangeClosed(1L, n).toArray();
        ForkJoinTask<Long> task = new ForkJoinSumCalculator(numbers);
        return new ForkJoinPool().invoke(task);
    }

    /**
     * 每个求和 function 的耗时的 测试方法
     * @param adder
     * @param n
     * @return
     */
    public static long measureSumPerf(Function<Long, Long> adder, long n) {
        long fastest = Long.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            Long sum = adder.apply(n);
            long duration = (System.nanoTime() - start) / 1_000_000;
            System.out.println("Result " + sum);
            if (duration < fastest) fastest = duration;
        }
        return fastest;
    }

    @Test
    public void testSequentialSum() {
        System.out.println("Sequential sum done in:" +
                measureSumPerf(ParallelStream::sequentialSum, 10_000_000) + " msecs");
    }

    @Test
    public void testParallelSum() {
        System.out.println("ParallelSum done in:" +
                measureSumPerf(ParallelStream::sequentialSum, 10_000_000) + " msecs");
    }

    @Test
    public void testforkJoinSum() {
        System.out.println("ForkJoin sum done in:" +
                measureSumPerf(ParallelStream::forkJoinSum, 10_000_000) + " msecs");
    }
}
