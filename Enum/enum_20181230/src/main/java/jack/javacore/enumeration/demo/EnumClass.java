package jack.javacore.enumeration.demo;

import jack.javacore.enumeration.Shrubbery;

/**
 * Theme:
 * <p>
 * Description:
 *
 * @author Zhengde ZHOU
 * Created on 2018-12-30
 */
public class EnumClass {

    public static void main(String[] args) {
        Shrubbery[] values = Shrubbery.values();
        Shrubbery ground = Shrubbery.valueOf("GROUND");
        Shrubbery ground1 = Shrubbery.GROUND;
        System.out.println(ground == ground1);

    }

}
