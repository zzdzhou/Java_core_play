package jack.javacore._null;

public class Car {

    private Insurance insurance;

    public Car() {

    }

    public Car(Insurance insurance) {
        this.insurance = insurance;
    }

    public Insurance getInsurance() {
        return this.insurance;
    }

    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
    }
}
