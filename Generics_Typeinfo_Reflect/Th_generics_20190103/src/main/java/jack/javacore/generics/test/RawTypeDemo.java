package jack.javacore.generics.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class RawTypeDemo {

    @Test
    public void test() {
        List list = null;
        list = new ArrayList<String>();
        list = new ArrayList<Integer>();
        Object o = list.get(0);
        list.add("wer");
        list.add(1);


        List<Object> listObj = null;
        // listObj = new ArrayList<String>(); // compile error: Incompatible types
        listObj = new ArrayList<>();
        Object o1 = listObj.get(0);
        listObj.add("sdf");
        listObj.add(1);

        List<String> listStr = null;

    }
}
