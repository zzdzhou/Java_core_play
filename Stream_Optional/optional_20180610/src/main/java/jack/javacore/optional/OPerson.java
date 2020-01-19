package jack.javacore.optional;

import java.util.Optional;

public class OPerson {

    private Optional<OCar> oCar = Optional.empty();

    public OPerson() {
    }

    public OPerson(Optional<OCar> oCar) {
        this.oCar = oCar;
    }

    public Optional<OCar> getOcar() {
        return this.oCar;
    }

    public void setOcar(Optional<OCar> oCar) {
        this.oCar = oCar;
    }
}
