package jack.java8.stream.collect;

import jack.java8.stream.Dish;
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
 * <p> an implementation of {@link Collector}
 * Description:
 *
 * @author Zhengde ZHOU
 * Created on 2018-10-17
 */
public class ToListCollector<T> implements Collector<T, List<T>, List<T>> {

    @Override
    public Supplier<List<T>> supplier() {
        return ArrayList::new;
    }

    @Override
    public BiConsumer<List<T>, T> accumulator() {
        return (list, t) -> {
            list.add(t);
            System.out.println(list);
        };
    }

    @Override
    public BinaryOperator<List<T>> combiner() {
        return (list1, list2) -> {
            list1.addAll(list2);
            return list1;
        };
    }

    @Override
    public Function<List<T>, List<T>> finisher() {
        return i -> i;
    }

    @Override
    public Set<Characteristics> characteristics() {
        HashSet<Characteristics> characteristics = new HashSet<>();
        characteristics.add(Characteristics.IDENTITY_FINISH);
        return characteristics;
    }

    public static void main(String[] args) {
        List<Dish> dishes = Sort.MENU.stream().collect(new ToListCollector<>());
        System.out.println(dishes);
    }

}
