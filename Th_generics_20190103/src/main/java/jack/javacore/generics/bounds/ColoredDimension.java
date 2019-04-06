package jack.javacore.generics.bounds;

import jack.javacore.generics.bounds.type.HasColor;

import java.awt.*;

/**
 * Theme:
 * <p> Multiple bounds
 * Description:
 *
 * @author Zhengde ZHOU
 * Created on 2019-02-03
 */
// This won’t work -- class must be first, then interfaces:
// class ColoredDimension<T extends HasColor & Dimension> {

// Multiple bounds:
class ColoredDimension<T extends jack.javacore.generics.bounds.type.Dimension & HasColor> {

    T item;

    ColoredDimension(T item) {
        this.item = item;
    }

    T getItem() { return item; }

    Color color() { return item.getColor(); }

    int getX() { return item.x; }
    int getY() { return item.y; }
    int getZ() { return item.z; }

}
