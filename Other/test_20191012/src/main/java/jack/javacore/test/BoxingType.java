package jack.javacore.test;

import org.junit.Test;

public class BoxingType {

    @Test
    public void test() {
        Integer i = 4;
        System.out.println(Integer.reverse(i));
        System.out.println(Integer.reverseBytes(i));
        System.out.println(0 - i);
    }
}
