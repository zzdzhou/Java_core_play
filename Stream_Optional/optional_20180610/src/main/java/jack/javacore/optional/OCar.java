package jack.javacore.optional;

import java.util.Optional;

public class OCar {

    private Optional<OInsurance> OInsurance = Optional.empty();

    public OCar() {
    }

    public OCar(Optional<OInsurance> OInsurance) {
        this.OInsurance = OInsurance;
    }

    public Optional<OInsurance> getOInsurance() {
        return this.OInsurance;
    }

    public void setOInsurance(Optional<OInsurance> OInsurance) {
        this.OInsurance = OInsurance;
    }
}
