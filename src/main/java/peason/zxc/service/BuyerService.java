package peason.zxc.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peason.zxc.dto.OrderDto;
import peason.zxc.enums.ResultEnum;
import peason.zxc.exception.SellException;

/**
 * Created by 廖师兄
 * 2017-06-22 00:13
 */
@Service
@Slf4j
public class BuyerService  {

    @Autowired
    private OrderService orderService;


    public OrderDto findOrderOne(String openid, String orderId) {
        return checkOrderOwner(openid, orderId);
    }


    public OrderDto cancelOrder(String openid, String orderId) {
        OrderDto orderDTO = checkOrderOwner(openid, orderId);
        if (orderDTO == null) {
            log.error("【取消订单】查不到改订单, orderId={}", orderId);
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }

        return orderService.cancel(orderDTO);
    }

    private OrderDto checkOrderOwner(String openid, String orderId) {
        OrderDto orderDTO = orderService.findOne(orderId);
        if (orderDTO == null) {
            return null;
        }
        //判断是否是自己的订单
        if (!orderDTO.getBuyerOpenid().equalsIgnoreCase(openid)) {
            log.error("【查询订单】订单的openid不一致. openid={}, orderDTO={}", openid, orderDTO);
            throw new SellException(ResultEnum.ORDER_OWNER_ERROR);
        }
        return orderDTO;
    }
}
