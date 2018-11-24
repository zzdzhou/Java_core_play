package jack.java8.stream.collect;

import jack.java8.stream.Sort;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * Theme:
 * <p>
 * Description:
 *
 * @author Zhengde ZHOU
 * Created on 2018-10-17
 */
public class CountingCollector<T> implements Collector<T, Long[], Long> {

    @Override
    public Supplier<Long[]> supplier() {
        return () -> new Long[]{0L};
    }

    @Override
    public BiConsumer<Long[], T> accumulator() {
        return (result, t) -> {
            result[0]++;
            System.out.println("log result = " + result[0]);
        };
    }

    @Override
    public BinaryOperator<Long[]> combiner() {
        return (l1, l2) -> {
            l1[0] = l1[0] + l2[0];
            return l1;
        };
    }

    @Override
    public Function<Long[], Long> finisher() {
        return l -> l[0];
    }

    @Override
    public Set<Characteristics> characteristics() {
        HashSet<Characteristics> characteristics = new HashSet<>();
        characteristics.add(Characteristics.UNORDERED);
        return characteristics;
    }

    public static void main(String[] args) {
        Long count = Sort.MENU.stream().collect(new CountingCollector<>());
        System.out.println("log count = " + count);
    }

}
