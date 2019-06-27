package peason.zxc.converter;

import org.springframework.beans.BeanUtils;
import peason.zxc.dataobject.OrderMaster;
import peason.zxc.dto.OrderDto;

import java.util.List;
import java.util.stream.Collectors;

public class OrderMaster2OrderDtoConverter {

    public static OrderDto convert(OrderMaster orderMaster) {

        OrderDto orderDTO = new OrderDto();
        BeanUtils.copyProperties(orderMaster, orderDTO);
        return orderDTO;
    }

    public static List<OrderDto> convert(List<OrderMaster> orderMasterList) {
        return orderMasterList.stream().map(e ->
                convert(e)
        ).collect(Collectors.toList());
    }
}
