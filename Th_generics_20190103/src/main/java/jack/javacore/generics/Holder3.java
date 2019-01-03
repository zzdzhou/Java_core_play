package jack.javacore.generics;

/**
 * Theme:
 * <p>
 * Description:
 *
 * @author Zhengde ZHOU
 * Created on 2019-01-03
 */
public class Holder3<T> {

    private T t;

    public Holder3(T t) {
        this.t = t;
    }

    public void set(T t) {
        this.t = t;
    }

    public T get() {
        return this.t;
    }

    public static void main(String[] args) {
        Holder3<Automobile> holder3 = new Holder3<>(new Automobile());
        Automobile automobile = holder3.get();
        // holder3.set("Not an Automobile"); // error
        // holder3.set(1); // error
    }

}
