package jack.java8.stream.collect;

import jack.java8.stream.Sort;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

/**
 * Theme:
 * <p>
 * Description:
 *
 * @author Zhengde ZHOU
 * Created on 2018-10-16
 */
public class CollectorTest {

    @Test
    public void count() {
        Long count = Sort.MENU.stream().collect(counting());
        System.out.println("log count = " + count);
    }

    @Test
    public void toList() {
        ArrayList<Integer> intList = new ArrayList<>();
        intList.add(0);
        intList.add(1);
        intList.add(2);
        intList.add(3);
        List<Integer> collect = intList.stream()
                .filter(i -> i > 5)
                .collect(Collectors.toList());
        System.out.println(collect);
        System.out.println(collect == null);
        System.out.println(collect.size());
    }

}
