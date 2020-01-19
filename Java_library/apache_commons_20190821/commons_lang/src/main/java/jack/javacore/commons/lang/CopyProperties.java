package jack.javacore.commons.lang;


import jack.javacore.commons.lang.common.Order;
import jack.javacore.commons.lang.common.OrderDTO;
import org.junit.Test;
import org.springframework.beans.BeanUtils;

public class CopyProperties {

    // target object's property is null
    // result is ok, copied
    @Test
    public void copyPropertiesBySpring() {

        boolean guest = 1L == 0;

        Order order = new Order();
        order.setName("order");
        order.setGuest(guest);

        OrderDTO orderDTO = new OrderDTO();
        System.out.println(orderDTO);

        BeanUtils.copyProperties(order, orderDTO);
        System.out.println(orderDTO);

        if (orderDTO.getGuest()) {
            System.out.println("if clause");
        }

    }

    // source object's property is null
    // result is ok, copied
    @Test
    public void copyPropertiesBySpring1() {
        Order order = new Order();
        order.setName("order");
        order.setGuest(true);
        System.out.println(order);

        OrderDTO orderDTO = new OrderDTO();
        System.out.println(orderDTO);

        BeanUtils.copyProperties(orderDTO, order);
        System.out.println(order);

    }
}
