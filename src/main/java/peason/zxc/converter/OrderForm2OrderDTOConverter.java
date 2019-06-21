package peason.zxc.converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.extern.slf4j.Slf4j;
import peason.zxc.dataobject.OrderDetail;
import peason.zxc.dto.OrderDto;
import peason.zxc.enums.ResultEnum;
import peason.zxc.exception.SellException;
import peason.zxc.form.OrderForm;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入参数转换为OrderDto
 */
@Slf4j
public class OrderForm2OrderDTOConverter {

    public static OrderDto convert(OrderForm orderForm) {
        Gson gson = new Gson();
        OrderDto orderDTO = new OrderDto();

        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());

        List<OrderDetail> orderDetailList = new ArrayList<>();
        try {
            orderDetailList = gson.fromJson(orderForm.getItems(),
                    new TypeToken<List<OrderDetail>>() {
                    }.getType());
        } catch (Exception e) {
            log.error("【对象转换】错误, string={}", orderForm.getItems());
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        orderDTO.setOrderDetailList(orderDetailList);

        return orderDTO;
    }
}
