package jack.javacore.reactor;

import org.junit.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.sql.SQLOutput;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class ReactorSnippets {

    private static List<String> words = Arrays.asList(
            "the",
            "quick",
            "brown",
            "fox",
            "jumped",
            "over",
            "the",
            "lazy",
            "dog"
    );

    @Test
    public void simpleCreation() {
        Flux<String> fewWords = Flux.just("hello", "world");
        Flux<String> manyWords = Flux.fromIterable(words);

        fewWords.subscribe(System.out::println);
        System.out.println();
        manyWords.subscribe(System.out::println);
    }

    @Test
    public void findMissingLetter() {
        System.out.println("findMissingLetter()");
        Flux<String> manyWords = Flux.fromIterable(words)
                .flatMap(word -> Flux.fromArray(word.split("")))
                .distinct()
                .sort()
                .zipWith(Flux.range(1, Integer.MAX_VALUE), (s, count) -> String.format("%2d. %s", count, s));
        manyWords.subscribe(System.out::println);
    }

    @Test
    public void addMissingLetter() {
        System.out.println("addMissingLetter()");
        Mono<String> missing = Mono.just("s");
        Flux<String> allLetters = Flux.fromIterable(words)
                .flatMap(word -> Flux.fromArray(word.split("")))
                .concatWith(missing)
                .distinct()
                .sort()
                .zipWith(Flux.range(1, 100), (s, count) -> String.format("%2d. %s", count, s));
        allLetters.subscribe(System.out::println);
    }

    @Test
    public void shortCircuit() throws InterruptedException {
        System.out.println("shortCircuit()");
        Flux<String> helloPauseWorld = Mono.just("hello")
                .concatWith(Mono.just("world"))
                /*.delaySubscription(Duration.ofMillis(1000))*/;
//        Thread.sleep(2000);
        helloPauseWorld.subscribe(System.out::println);
//        helloPauseWorld.toStream().forEach(System.out::println);

    }

    @Test
    public void test() {
        System.out.println("test()");
        String s = "boo";
        String[] split = s.split("");

        for (int i = 0; i < split.length; i++) {
            System.out.println(split[i]);
        }

        List<String> sList = Arrays.asList("words", "seeds");
        Flux.fromIterable(sList)
                .flatMap(str -> Flux.fromArray(str.split("")))
                .distinct()
                .sort()
                .subscribe(System.out::println);
    }

}
