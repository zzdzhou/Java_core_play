package jack.javacoreplay.stream;

import org.junit.Test;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamSnippet {

    private static List<Dish> menu = Arrays.asList(
            new Dish("pork", false, 800, Dish.Type.MEAT),
            new Dish("beef", false, 700, Dish.Type.MEAT),
            new Dish("chicken", false, 400, Dish.Type.MEAT),
            new Dish("french fries", true, 530, Dish.Type.OTHER),
            new Dish("rice", true, 350, Dish.Type.OTHER),
            new Dish("season fruit", true, 120, Dish.Type.OTHER),
            new Dish("pizza", true, 550, Dish.Type.OTHER),
            new Dish("prawns", false, 300, Dish.Type.FISH),
            new Dish("salmon", false, 450, Dish.Type.FISH) );

    @Test
    public void java7Snippt() {
        ArrayList<Dish> lowCaloricDishes = new ArrayList<Dish>();
        for (Dish item : menu) {
            if (item.getCalories() < 400) {
                lowCaloricDishes.add(item);
            }
        }
        Collections.sort(lowCaloricDishes, new Comparator<Dish>() {
            public int compare(Dish o1, Dish o2) {
                return Integer.compare(o1.getCalories(), o2.getCalories());
            }
        });

        ArrayList<String> lowCaloricDishNames = new ArrayList<>();
        for (Dish item : lowCaloricDishes) {
            lowCaloricDishNames.add(item.getName());
        }
    }

    @Test
    public void java8Snippet() {
        menu.stream()
                .filter(dish -> dish.getCalories() < 400)
                //.sorted((d1, d2) -> Integer.compare(d1.getCalories(), d2.getCalories()))
                .sorted(Comparator.comparing(Dish::getCalories))
                .map(Dish::getName)
                .collect(Collectors.toList());
    }

}
