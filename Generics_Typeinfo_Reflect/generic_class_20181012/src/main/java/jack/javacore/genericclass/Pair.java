package jack.javacore.genericclass;

/**
 * 自定义 generic class
 * @author Java 核心技术卷I 10th
 */
public class Pair<T> {

    private T first;
    private T second;

    public Pair() {

    }

    public Pair(T t1, T t2) {
        this.first = t1;
        this.second = t2;
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public T getSecond() {
        return second;
    }

    public void setSecond(T second) {
        this.second = second;
    }

}
