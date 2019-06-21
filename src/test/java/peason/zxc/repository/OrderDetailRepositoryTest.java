package peason.zxc.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import peason.zxc.dataobject.OrderDetail;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository repository;

    @Test
    public void saveTest(){
        OrderDetail orderDetial = new OrderDetail();
        orderDetial.setDetailId("1234567810");
        orderDetial.setOrderId("11111");
        orderDetial.setProductIcon("http://xxx.jpg");
        orderDetial.setProductId("12315416");
        orderDetial.setProductName("皮蛋粥2");
        orderDetial.setProductPrice(new BigDecimal(2.2));
        orderDetial.setProductQuantity(3);

        OrderDetail save = repository.save(orderDetial);
        Assert.assertNotNull(save);
    }

    @Test
    public void findByBuyerOrderid(){
        List<OrderDetail> byOrOrderId = repository.findByOrOrderId("11111");
        Assert.assertNotEquals(0,byOrOrderId.size());
    }

}