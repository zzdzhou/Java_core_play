package jack.javacore.optional2;

import java.util.Optional;

public class Person {

    private Car car;

    public Optional<Car> getCarAsOptional() {
        return Optional.ofNullable(this.car);
    }
}
