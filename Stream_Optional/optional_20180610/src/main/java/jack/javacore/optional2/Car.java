package jack.javacore.optional2;

import java.util.Optional;

public class Car {

    private Insurance insurance;

    public Optional<Insurance> getInsuranceAsOptional() {
        return Optional.ofNullable(this.insurance);
    }
}
