package peason.zxc.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import peason.zxc.enums.OrderStatusEnum;
import peason.zxc.enums.PayStatusEnum;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Data
@DynamicUpdate
public class OrderMaster {

    /**
     * 订单id
     */
    @Id
    private String orderId;

    /**
     * 买家名字
     */
    private String buyerName;

    /**
     * 买家电话
     */
    private String buyerPhone;

    /**
     * 买家地址
     */
    private String buyerAddress;

    /**
     * 买家微信的Openid
     */
    private String buyerOpenid;

    /**
     * 订单总金额
     */
    private BigDecimal orderAmount;

    /**
     *  订单状态默认为0
     */
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();

    /**
     * 支付状态默认为0
     */
    private Integer payStatus = PayStatusEnum.WAIT.getCode();

    private Date createTime;

    private Date updateTime;


/*    @Transient      //数据库不映射
    private List<OrderDetail> orderDetailList;*/


}
