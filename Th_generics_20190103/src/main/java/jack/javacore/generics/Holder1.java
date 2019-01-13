package jack.javacore.generics;

/**
 * Theme:
 * <p>
 * Description:
 *
 * @author Zhengde ZHOU
 * Created on 2019-01-03
 */
public class Holder1 {

    private Automobile a;

//    @SuppressWarnings("unchecked")
    public Holder1(Automobile a) {
        this.a = a;
    }

    Automobile get() {
        return a;
    }

}
