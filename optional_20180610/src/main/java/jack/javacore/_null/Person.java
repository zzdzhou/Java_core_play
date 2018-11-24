package jack.javacore._null;

public class Person {

    private Car car;

    public Person() {
    }

    public Person(Car car) {
        this.car = car;
    }

    public Car getCar() {
        return this.car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
