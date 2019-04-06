package jack.javacore.generics.bounds;

import jack.javacore.generics.bounds.type.HasColor;

import java.awt.*;

/**
 * Theme:
 * <p> Bounds & extends
 * Description:
 *
 * @author Zhengde ZHOU
 * Created on 2019-02-03
 */
public class Colored<T extends HasColor> {

    T item;

    Colored(T item) {
        this.item = item;
    }

    // The bound allows you to call a method:
    Color color() {
        return item.getColor();
    }

}
