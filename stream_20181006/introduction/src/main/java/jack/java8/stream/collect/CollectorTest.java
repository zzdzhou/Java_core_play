package jack.java8.stream.collect;

import jack.java8.stream.Sort;
import org.junit.Test;

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

}
