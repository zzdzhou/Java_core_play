package jack.javacore.generics;

/**
 * Theme:
 * <p>
 * Description:
 *
 * @author Zhengde ZHOU
 * Created on 2019-01-03
 */
public class Holder2 {

    private Object a;

    public Holder2(Object a) {
        this.a = a;
    }

    public void set(Object a) {
        this.a = a;
    }

    public Object get() {
        return this.a;
    }

    public static void main(String[] args) {
        Holder2 holder2 = new Holder2(new Automobile());
        Automobile o = (Automobile) holder2.get();
        holder2.set("Not an Automobile");
        String s = (String) holder2.get();
        holder2.get();
        holder2.set(1);
        Integer x = (Integer) holder2.get();

    }

}
