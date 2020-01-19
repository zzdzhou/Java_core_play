package jack.javacore.generics.erasure.problem.of.erasure;

public class ErasureAndInheritance {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Derived2 derived2 = new Derived2();
        Object o = derived2.get();
        derived2.set(o); //Waining here:
        // Unchecked call to 'set(T)' as a member of raw type 'jack.javacore.generics.erasure.problem.of.erasure.GenericBase'
    }
}
