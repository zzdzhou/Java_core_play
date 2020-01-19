package jack.javacore.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class GetIPByDomainName {

    public static void main(String[] args) {
        try {
            InetAddress byName = InetAddress.getByName("pms2-uat.d1m.cn");
            String ip = byName.getHostAddress(); //Returns the IP address string in textual presentation.
            System.out.println(ip);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }
}
