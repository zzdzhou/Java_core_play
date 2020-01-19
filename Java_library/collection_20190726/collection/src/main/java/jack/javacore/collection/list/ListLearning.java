package jack.javacore.collection.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ListLearning {

    @Test
    public void List() {

    }

    @Test
    public void objectFromList() {
        List<String> strList = new ArrayList<>();
        String s = "initial";
        strList.add(s);
        System.out.println(strList);

        s = "change";
        System.out.println(strList);

        //
        List<String> strList1 = new ArrayList<>();
        strList1.add("initial");
        System.out.println(strList1);

        String s1 = strList.get(0);
        System.out.println(strList1);

        //
        List<Pojo> list = new ArrayList<>();
        list.add(new Pojo("pojo"));
        System.out.println(list);
        Pojo pojo = list.get(0);
        pojo.setS("not pojo");
        System.out.println(list);

        //
        List<Pojo> list1 = new ArrayList<>();
        Pojo pojo1 = new Pojo("pojo");
        list1.add(pojo1);
        System.out.println(list1);
        pojo1.setS("not pojo");
        System.out.println(list1);
    }

    private class Pojo {
        private String s;

        public Pojo(String s) {
            this.s = s;
        }

        public String getS() {
            return s;
        }

        public void setS(String s) {
            this.s = s;
        }

        @Override
        public String toString() {
            return this.s;
        }
    }

}
