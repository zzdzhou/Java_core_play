package jack.javacore.typeinfo;

import java.util.Arrays;
import java.util.List;

/**
 * Theme:
 * <p>
 * Description:
 *
 * @author Zhengde ZHOU
 * Created on 2019-01-03
 */
public class Shapes {

    public static void main(String[] args) {
        List<Shape> shapes = Arrays.asList(new Circle(), new Square(), new Triangle());
        for (Shape item : shapes) {
            item.draw();
        }
    }

}
