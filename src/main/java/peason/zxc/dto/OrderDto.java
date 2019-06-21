package peason.zxc.dto;

import lombok.Data;
import peason.zxc.dataobject.OrderDetail;
import peason.zxc.enums.OrderStatusEnum;
import peason.zxc.enums.PayStatusEnum;

import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class OrderDto {
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
    private Integer orderStatus ;

    /**
     * 支付状态默认为0
     */
    private Integer payStatus ;

    private Date createTime;

    private Date updateTime;


   //@Transient      //数据库不映射
    private List<OrderDetail> orderDetailList;
}
