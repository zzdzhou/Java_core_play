package jack.java8.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Map {

    private static List<String> WORDS = Arrays.asList("Java 8", "Lambdas", "In", "Action");

    @Test
    public void flagMap() {
        List<String> results = WORDS.stream()
                .map(s -> s.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(results);
    }
}
