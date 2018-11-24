package jack.java8.stream;

import org.junit.Test;

import java.util.stream.Stream;

public class CreatingStream {

    @Test
    public void iterate() {
        Stream.iterate(0, n -> n + 2)
                .limit(20)
            .forEach(System.out::println);
    }
}
