package jack.javacore.generics.wildcards;

import jack.javacore.generics.wildcards.pojo.Apple;
import jack.javacore.generics.wildcards.pojo.Jonathan;

import java.util.List;

public class SuperTypeWildcards {

    static void writeTo(List<? super Apple> apples) {
        apples.add(new Apple());
        apples.add(new Jonathan());
        //apples.add(new Fruit()); //Error
    }
}
