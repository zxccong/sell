package peason.zxc.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;
import peason.zxc.dataobject.OrderMaster;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {
    @Autowired
    private OrderMasterRepository repository;

    private final String OPENID= "110110";

    @Test
    public void saveTest(){
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("123456");
        orderMaster.setBuyerName("师兄");
        orderMaster.setBuyerPhone("123456789132");
        orderMaster.setBuyerOpenid("110110");
        orderMaster.setBuyerAddress("慕课网");
        orderMaster.setOrderAmount(new BigDecimal(2.5));

        OrderMaster save = repository.save(orderMaster);
        Assert.assertNotNull(save);
    }

    @Test
    public void findByBuyerOpenid(){
        PageRequest pageRequest = new PageRequest(0, 3);
        Page<OrderMaster> byBuyerOpenid = repository.findByBuyerOpenid(OPENID, pageRequest);
        Assert.assertNotEquals(0,byBuyerOpenid.getTotalElements());
    }
}