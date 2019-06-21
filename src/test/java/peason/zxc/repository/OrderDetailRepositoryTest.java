package peason.zxc.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import peason.zxc.dataobject.orderDetail;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository repository;

    @Test
    public void saveTest(){
        orderDetail orderDetial = new orderDetail();
        orderDetial.setDetailId("123456789");
        orderDetial.setOrderId("11111");
        orderDetial.setProductIcon("http://xxx.jpg");
        orderDetial.setProductId("12315416");
        orderDetial.setProductName("皮蛋粥");
        orderDetial.setProductPrice(new BigDecimal(1.2));
        orderDetial.setProductQuantity(2);

        orderDetail save = repository.save(orderDetial);
        Assert.assertNotNull(save);
    }

    @Test
    public void findByBuyerOrderid(){

    }

}