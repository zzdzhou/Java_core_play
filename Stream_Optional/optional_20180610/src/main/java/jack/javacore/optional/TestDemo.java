package jack.javacore.optional;

import org.junit.Test;

import java.util.Optional;

public class TestDemo {

    private OInsurance insurance1 = new OInsurance("The Pacific");
    /*private Car car1 = new Car(insurance1);
    private Person person1 = new Person(car1);

    private Person person2 = new Person(new Car());*/

    private OPerson oPerson1 = new OPerson(Optional.ofNullable(
            new OCar(Optional.ofNullable(new OInsurance("The Pacific")))));
    private OPerson oPerson2 = new OPerson(Optional.ofNullable(new OCar()));


    @Test
    public void test2() {
        Optional<OInsurance> optInsurance1 = Optional.ofNullable(this.insurance1);
        Optional<String> optName = optInsurance1.map(OInsurance::getName);
        System.out.println(optName);
    }

    @Test
    public void test3() {
//        Optional<Person> optPerson1 = Optional.ofNullable(this.person1);
//        Optional<Optional<OCar>> car = optPerson.map(OPerson::getOcar);

        Optional<OPerson> optOPerson1 = Optional.ofNullable(this.oPerson1);

        String result = optOPerson1.flatMap(OPerson::getOcar)
                .flatMap(OCar::getOInsurance)
                .map(OInsurance::getName)
                .orElse("unknown");
        System.out.println(result);

        Optional<OPerson> optOPerson2 = Optional.ofNullable(this.oPerson2);

        optOPerson2.flatMap(OPerson::getOcar);

        String result2 = optOPerson2.flatMap(OPerson::getOcar)
                .flatMap(OCar::getOInsurance) //OCar is null
                .map(OInsurance::getName)
                .orElse("unknown");
        System.out.println(result2);
    }
}
