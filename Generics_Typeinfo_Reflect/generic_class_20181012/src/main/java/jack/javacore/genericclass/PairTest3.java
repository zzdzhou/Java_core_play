package jack.javacore.genericclass;

import jack.javacore.genericclass.pojo.*;
import org.junit.Test;

/**
 * Theme:
 * <p> 8.8.1 泛型通配符概念
 * Description:
 *
 * @author ava 核心技术 卷I 10th
 * Created on 20181013
 */
public class PairTest3 {

    /**
     * {@link Manager} 是 {@link Employee} 的子类，但 不能将 {@link Pair<Manager>} 传递给这个方法，这一点很受限制。
     * 解决的方法很简单：使用通配符类型：Pair<? extends Employee>
     *
     * @param p
     */
    public static void printBuddies(Pair<Employee> p) {
        Employee first = p.getFirst();
        Employee second = p.getSecond();
        System.out.println(first.getName() + " and " + second.getName() + " are buddies.");
    }

    /**
     * 使用通配符会通过 Pair<? extends Employee> 的引用破坏 Pair<Manager> 吗？
     * 这不会引起破坏。对 setFirst 的调用有一个类型错误。
     *
     * ? extends Employee getFi rstO
     * void setFirst(? extends Employee)
     * 编译器只知道需要某个 Employee 的子类型，但不知道具体是什么类型。
     * 它拒绝传递任何特定的类型。毕竟？不能用来匹配。
     *
     * 使用 getFirst 就不存在这个问题： 将 getFirst 的返回值赋给一个 Employee 的引用完全合法。
     *
     * 这就是引人有限定的通配符的关键之处。
     */
    public static void test() {
        Manager ceo = null;
        Manager cfo = null;
        Employee lowlyEmployee = null;
        Pair<Manager> managerBuddies = new Pair<>(ceo, cfo);
        Pair<? extends Employee> wildcardBuddies = managerBuddies;
        //wildcardBuddies.setFirst(lowlyEmployee); //compile-time error
    }

    /**
     * 8.8.2 泛型通配符的 超类型限定 ? super Manager
     * @param a
     * @param result
     */
    public static void minMaxBonus(Manager[] a, Pair<? super Manager> result) {
        if (a.length == 0) {
            return;
        }
        Manager min = a[0];
        Manager max = a[0];
        for (int i = 1; i < a.length; ++i) {
            if (a[i].getBonus() < min.getBonus()) {
                min = a[i];
            }
            if (a[i].getBonus() > max.getBonus()) {
                max = a[i];
            }
        }
        result.setFirst(min);
        result.setFirst(max);

    }

    /**
     * 8.8.2 泛型通配符的 超类型限定 ? super Manager
     */
    @Test
    public void superLimit() {
        Employee e1 = new Employee("Jack", 100L, 2018, 3, 9);
        Employee e2 = new Employee("Sl", 122L, 2014, 2, 5);
        Manager ceo = new Manager("jsk", 1000L, 2017, 9, 20);

        Pair<Employee> employeePair = new Pair<>(e1, e2);
        Pair<? super Manager> p = null;
        p = employeePair; // 可以将 Pair<Employee> 赋值给 Pair<? super Manager> p
        System.out.println("first: " + p.getFirst() + "\nsecond: " + p.getSecond());

        p.setFirst(ceo); // 但不能将 Employee 传递给 p.setFirst() 方法
        System.out.println("first: " + p.getFirst() + "\nsecond: " + p.getSecond());
    }

}
