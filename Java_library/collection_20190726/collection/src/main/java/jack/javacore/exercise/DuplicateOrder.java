package jack.javacore.exercise;

import org.junit.Test;

import java.util.*;

public class DuplicateOrder {

    @Test
    public void main() {
        List<String> param = new ArrayList<>();
        param.add("a");
        param.add("f");
        param.add("v");
        param.add("t");
        param.add("a");
        param.add("i");
        param.add("i");
        param.add("i");
        param.add("a");
        param.add("t");
        param.add("a");
        param.add("t");
        param.add("s");
        param.add("s");

        Map<String, Integer> map = new HashMap<>();
        for (String item : param) {
            map.put(item, map.getOrDefault(item, 0) + 1);
        }
        System.out.println(map);

        Collection<Integer> values = map.values();
        ArrayList<Integer> valueList = new ArrayList<>(values);
        valueList.sort((x, y) -> (x > y) ? -1 : ((x == y)? 0:1));
//        valueList.stream().sorted().collect()

        Set<String> keySet = map.keySet();
        HashSet<String> keySet1 = new HashSet<>(keySet);

        for (Integer item : valueList) {
            map.forEach((s, v) -> {
                if (v == item && v > 1 && keySet1.contains(s)) {
                    System.out.println(s + " " + v);
                    keySet1.remove(s);
                }
            });
        }
    }

}
