package jack.javacore.generics.bounds;

import jack.javacore.generics.bounds.type.HasColor;
import jack.javacore.generics.bounds.type.Weight;
import jack.javacore.generics.bounds.type.Dimension;

import java.awt.Color;

/**
 * Theme:
 * <p>
 * Description:
 *
 * @author Zhengde ZHOU
 * Created on 2019-02-03
 */
public class Bounded extends Dimension implements HasColor, Weight {


    @Override
    public Color getColor() {
        return null;
    }

    @Override
    public int weight() {
        return 0;
    }
}
