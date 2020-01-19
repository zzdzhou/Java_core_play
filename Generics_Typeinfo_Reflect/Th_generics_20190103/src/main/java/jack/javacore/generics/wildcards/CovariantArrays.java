package jack.javacore.generics.wildcards;

import jack.javacore.generics.wildcards.pojo.Apple;
import jack.javacore.generics.wildcards.pojo.Fruit;
import jack.javacore.generics.wildcards.pojo.Jonathan;
import jack.javacore.generics.wildcards.pojo.Orange;

/**
 * Theme:
 * <p> 数组向上转型是不合适的
 * 数组对象可以记住 持有对象类型
 * 泛型的主要目标之一就是将这种错误检查移入到编译期
 * Description:
 *
 * @author Zhengde ZHOU
 * Created on 2019-02-03
 */
public class CovariantArrays {

    public static void main(String[] args) {
        Fruit[] fruit = new Apple[10];
        fruit[0] = new Apple(); // OK // 数组对象可以保留 持有对象类型 Apple
        fruit[1] = new Jonathan(); // OK
        // Runtime type is Apple[], not Fruit[] or Orange[]:

        try {
            // Compiler allows you to add Fruit:
            // 可通过编译器检查，但运行时报错
            fruit[0] = new Fruit(); // ArrayStoreException
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            // Compiler allows you to add Oranges:
            fruit[0] = new Orange(); // ArrayStoreException
        } catch (Exception e) {
            System.out.println(e);
        }

        // compile error, incompatible types
        //ArrayList<Fruit> fruits = new ArrayList<Apple>();

    }

}
