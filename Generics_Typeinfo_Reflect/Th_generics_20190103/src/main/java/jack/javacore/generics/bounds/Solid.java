package jack.javacore.generics.bounds;

import jack.javacore.generics.bounds.type.HasColor;
import jack.javacore.generics.bounds.type.Weight;
import jack.javacore.generics.bounds.type.Dimension;

import java.awt.Color;

/**
 * Theme:
 * <p> Multiple bounds / only one concrete class but multiple interfaces
 * Description:
 *
 * @author Zhengde ZHOU
 * Created on 2019-02-03
 */
// As with inheritance, you can have only one
// concrete class but multiple interfaces:
class Solid <T extends Dimension & HasColor & Weight> {

    T item;

    Solid(T item) { this.item = item; }

    T getItem() { return item; }

    Color color() { return item.getColor(); }

    int getX() { return item.x; }
    int getY() { return item.y; }
    int getZ() { return item.z; }
    int weight() { return item.weight(); }

}
