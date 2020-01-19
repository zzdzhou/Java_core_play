package jack.java8.stream.parallel;

import java.util.concurrent.RecursiveTask;

/**
 * Theme:
 * <p> 7.2 分支/合并框架
 *
 * Description:
 * 继承{@link RecursiveTask}来创建可用于分支/分支合并框架的任务
 *
 * @author Java8 实战.pdf
 * Created on 2018-10-20
 */
public class ForkJoinSumCalculator extends RecursiveTask<Long> {

    /**
     * 可用于求和的数组
     */
    private long[] numbers;

    /**
     * 子任务处理的数组的开始位置
     */
    private int start;

    /**
     * 子任务处理的数组的结束位置
     */
    private int end;

    /**
     * 不在将任务分解为子任务的数组大小
     */
    private static final long THRESHOLD = 10_000;

    /**
     * 公有构造器
     * @param numbers
     */
    public ForkJoinSumCalculator(long[] numbers) {
        this(numbers, 0, numbers.length);
    }

    /**
     * 私有构造器
     * @param numbers
     * @param start
     * @param end
     */
    private ForkJoinSumCalculator(long[] numbers, int start, int end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }


    @Override
    protected Long compute() {
        int length = end - start; // 该任务求和的部分的大小
        // 如果小于或等于阈值，顺序计算结果
        if (length <= THRESHOLD) {
            return this.computeSequentially();
        }
        //
        ForkJoinSumCalculator leftTask = new ForkJoinSumCalculator(numbers, start, start + length / 2); // 创建一个子任务为数组的前一半求和
        leftTask.fork(); // 利用另一个 ForkJoinPool 中的子线程异步执行新创建的子任务
        ForkJoinSumCalculator rightTask = new ForkJoinSumCalculator(numbers, start + length / 2, end);  // 创建一个子任务为数组的后一半求和
        Long rightResult = rightTask.compute();     //同步执行第二个子任务，有可能进一步递归划分
        Long leftResult = leftTask.join();  // 读取第一个子任务的结果，如果尚未完成就等待
        return leftResult + rightResult;
    }

    /**
     * 在子任务不可分时，计算结果的简单方法
     * @return
     */
    private long computeSequentially() {
        long sum = 0L;
        for (int i = start; i < numbers.length; i++) {
            sum += numbers[i];
        }
        return sum;
    }

}
