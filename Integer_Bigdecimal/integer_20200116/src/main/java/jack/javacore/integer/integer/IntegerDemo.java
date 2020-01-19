package jack.javacore.integer.integer;

import org.junit.Test;

public class IntegerDemo {

    @Test
    public void equals() {
        Integer a = 12;
        Integer a1 = 12;
        Integer a2 = 1;

        Integer b = 1234;
        Integer b1 = 1234;

        System.out.println(a == a1);
        System.out.println(a == a2);

        System.out.println(b == b1);
        System.out.println(b.intValue() == b1.intValue());

    }
}
