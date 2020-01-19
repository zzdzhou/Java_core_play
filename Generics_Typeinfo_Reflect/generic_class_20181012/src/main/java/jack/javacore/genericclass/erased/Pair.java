package jack.javacore.genericclass.erased;

import java.util.ArrayList;

/**
 * Theme:
 * <p> 8.5.1 类型擦除
 *
 * Description:
 * {@link jack.javacore.genericclass.Pair} 经过类型擦除之后的类
 *
 * 无论怎么定义一个泛型类型，虚拟机都自动提供了一个相应的原始类型。
 * 原始类型的名字就是去掉类型参数后的类名。擦除类型变量，并替换为限定类型，无限定类型变量用Object代替。
 *
 * @author Java 核心技术 卷I 10th
 * Created on 20181012
 */
public class Pair {

    private Object first;
    private Object second;

    public Pair() {

    }

    public Pair(Object t1, Object t2) {
        this.first = t1;
        this.second = t2;
    }

    public Object getFirst() {
        return first;
    }

    public void setFirst(Object first) {
        this.first = first;
    }

    public Object getSecond() {
        return second;
    }

    public void setSecond(Object second) {
        this.second = second;
    }

}
