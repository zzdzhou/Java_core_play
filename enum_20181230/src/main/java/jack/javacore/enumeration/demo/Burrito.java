package jack.javacore.enumeration.demo;

import jack.javacore.enumeration.Spiciness;

import static jack.javacore.enumeration.Spiciness.*;

/**
 * Theme:
 * <p>
 * Description:
 *
 * @author Zhengde ZHOU
 * Created on 2018-12-30
 */
public class Burrito {

    Spiciness degree;

    public Burrito(Spiciness degree) {
        this.degree = degree;
    }

    public static void main(String[] args) {
        System.out.println(new Burrito(NOT));
        System.out.println(MILD);
        System.out.println(HOT);
    }

}
