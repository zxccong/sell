package peason.zxc.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import peason.zxc.dataobject.ProductInfo;

import javax.transaction.Transactional;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {

    @Autowired
    private ProductInfoRepository repository;

    /**
     * 保存更新设置
     */
    @Test
    public void saveTest(){
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123456");
        productInfo.setProductName("皮蛋粥");
        productInfo.setProductPrice(new BigDecimal(3.2));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("很好喝的粥");
        productInfo.setProductIcon("http://xxxx.jpg");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(3);

        ProductInfo save = repository.save(productInfo);
        Assert.assertNotNull(save);
//        Assert.assertNotEquals(null,save);//相同
    }

    @Test
    public void findByProductStatus(){
        List<ProductInfo> byProductStatus = repository.findByProductStatus(0);
        Assert.assertNotEquals(0,byProductStatus.size());
    }
}