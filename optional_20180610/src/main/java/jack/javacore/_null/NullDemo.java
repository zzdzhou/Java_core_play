package jack.javacore._null;

import org.junit.Test;

public class NullDemo {

    private Insurance insurance1 = new Insurance("The Pacific");
    private Car car1 = new Car(insurance1);
    private Person person1 = new Person(car1);

    @Test
    public void test1() {
        String name = person1.getCar().getInsurance().getName();
    }

    @Test
    public void test11() {
        if (person1 != null) {
            Car car1 = person1.getCar();
            if (car1 != null) {
                Insurance insurance1 = car1.getInsurance();
                if (insurance1 != null) {
                    System.out.println(insurance1.getName());
                }
            }
        }
    }

}
