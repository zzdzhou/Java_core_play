package jack.javacore.generics.wildcards;

import java.util.ArrayList;
import java.util.List;

/**
 * Theme:
 * <p>
 * Description:
 *
 * @author Zhengde ZHOU
 * Created on 2019-02-03
 */
public class GenericsAndCovariance {

    public static void main(String[] args) {
        // Wildcards allow covariance:
        List<? extends Fruit> flist = new ArrayList<Apple>();

        // Compile Error: can’t add any type of object:
        // flist.add(new Apple());
        // flist.add(new Fruit());
        // flist.add(new Object());

        flist.add(null); // Legal but uninteresting

        // We know that it returns at least Fruit:
        Fruit f = flist.get(0);
    }
}
