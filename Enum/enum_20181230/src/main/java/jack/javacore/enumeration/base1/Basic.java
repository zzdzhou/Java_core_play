package jack.javacore.enumeration.base1;

import org.junit.Test;

public class Basic {

    @Test
    public void basicMethods() {
        System.out.println(Quarter.WINTER);
        Quarter winter = Quarter.valueOf(null);
        switch (winter) {
            case WINTER:
                System.out.println("winter");
            default:
                System.out.println("default");
        }
    }
}
