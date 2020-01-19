package jack.javacore.test;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringTest {

    @Test
    public void test() {
        System.out.println("*AL".contains("*ALL"));

        String userAgent = "";
        List<String> strList = new ArrayList<>();
        strList.add("Mobile");
        strList.add("*ALL");
        strList.add("Android");
        strList.add("MicroMessenger");
        String found = Iterables.find(strList, new Predicate<String>() {
            @Override
            public boolean apply(String ua) {
                return userAgent.contains(ua);
            }
        });
        System.out.println(found);
    }

    @Test
    public void test1() {
        String[] s = new String[]{"jack.zhou@richemont.com", "1600@jack.com"};
        System.out.println(Arrays.toString(s));
        System.out.println(StringUtils.substring(Arrays.toString(s), 1, Arrays.toString(s).length() - 1).toString());
    }

}
