package jack.javacore.generics.erasure;

public class Manipulator<T> {
    private T obj;

    public Manipulator(T x) {
        obj = x;
    }

    public void manipulate() {
//        obj.f();
        // Error: Cannot resolve mehtod 'f()'
    }
}
