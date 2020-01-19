package jack.javacore.collection;

import javax.swing.text.html.Option;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Test {

    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        Optional.of(map).ifPresent(m -> {
            Integer test = getOrdeDefalut(map, "test", 0);
            if (test == 0) {
                System.out.println("Success");
            } else {
                System.out.println("Failed");
            }
        });

    }

    public static <T> T getOrdeDefalut(Map<String, Object> obj, String key, T defaultVal) {
        try {
            return (T) obj.get(key);
        } catch (Exception e) {
            return defaultVal;
        }
    }
}
