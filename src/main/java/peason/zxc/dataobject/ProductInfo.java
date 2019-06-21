package peason.zxc.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * 商品表
 */
@Entity
@Data
public class ProductInfo {

    /**
     * id
     */
    @Id
    private String productId;

    /**
     * 商品名字
     */
    private String productName;

    /**
     * 商品价格
     */
    private BigDecimal productPrice;

    /**
     * 库存
     */
    private Integer productStock;

    /**
     * 商品描述
     */
    private String productDescription;

    /**
     * 商品图标
     */
    private  String productIcon;

    /**
     * 状态0正常1下架
     */
    private  Integer productStatus;

    /**
     * 分类类别
     */
    private Integer categoryType;


}
