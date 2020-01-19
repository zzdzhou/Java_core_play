package jack.javacore.typeinfo;

/**
 * Theme:
 * <p>
 * Description:
 *
 * @author Zhengde ZHOU
 * Created on 2019-01-03
 */
public abstract class Shape {

    public void draw() {
        System.out.println(this + ".draw()");
    }

    abstract public String toString();
}
