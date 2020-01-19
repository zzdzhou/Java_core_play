package jack.javacore.generics.wildcards;

import jack.javacore.generics.wildcards.pojo.Apple;
import jack.javacore.generics.wildcards.pojo.Fruit;

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
        //ArrayList<Apple>: Apple 会被擦除为Object，
        //List<? extends Fruit>： 会被擦除为 Fruit


        // Compile Error: can’t add any type of object:
        // flist.add(new Apple());
        // add(capture<? extends jack.javacore.generics.wildcards.pojo.Fruit> in List cannot be applied to add(jack.javacore.generics.wildcards.pojo.Apple))
        // flist.add(new Fruit());
        // flist.add(new Object());

        flist.add(null); // Legal but uninteresting

        // We know that it returns at least Fruit:
        Fruit f = flist.get(0);
    }
}
