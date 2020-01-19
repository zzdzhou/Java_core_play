package jack.javacore.generics.erasure.problem.of.erasure;

public class GenericBase<T> {

    private T element;

    public void set(T t) {
        element = t;
    }

    public T get() {
        return element;
    }
}
