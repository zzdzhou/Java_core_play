package jack.javacore.commons.lang;

import org.junit.Test;

public class StringUtils {

    @Test
    public void testStringUtils() {
        System.out.println(org.apache.commons.lang3.StringUtils.length(null));
        System.out.println(org.apache.commons.lang3.StringUtils.length("  "));
        System.out.println(org.apache.commons.lang3.StringUtils.length("afd"));
    }
}
