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

    @Id
    private String productId;

    private String productName;

    private BigDecimal productPrice;

    private Integer productStock;

    private String productDescription;

    private  String productIcon;

    /**
     * 状态0正常1下架
     */
    private  Integer productStatus;

    private Integer categoryType;


}
