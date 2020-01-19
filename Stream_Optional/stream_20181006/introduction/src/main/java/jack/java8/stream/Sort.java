package jack.java8.stream;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class Sort {

    public static List<Dish> MENU = Arrays.asList(
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
    public void sortInJava7() {
        List<Dish> lowCaloricDishes = new ArrayList<>();
        for (Dish item : MENU) {
            if (item.getCalories() < 400) {
                lowCaloricDishes.add(item);
            }
        }

        Collections.sort(lowCaloricDishes, new Comparator<Dish>() {
            @Override
            public int compare(Dish o1, Dish o2) {
                return Integer.compare(o1.getCalories(), o2.getCalories());
            }
        });

        List<String> lowCaloricDishNames = new ArrayList<>();
        for (Dish item : lowCaloricDishes) {
            lowCaloricDishNames.add(item.getName());
        }
        for (String item : lowCaloricDishNames) {
            System.out.println(item);
        }
    }

    @Test
    public void sortInJava8() {
        List<String> localCaloricDishNames = MENU.stream()
                .filter(d -> {
                    System.out.println("log filter " + d.getName());
                    return d.getCalories() < 400;
                })
                .sorted((d1, d2) -> Integer.compare(d1.getCalories(), d2.getCalories()))
                .map(d -> {
                    System.out.println("log map " + d.getName());
                    return d.getName();
                })
                .limit(3)
                .collect(Collectors.toList());

        System.out.println(localCaloricDishNames);
    }

}
