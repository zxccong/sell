package peason.zxc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import peason.zxc.dataobject.OrderDetail;

import java.util.List;

public interface OrderDetailRepository extends JpaRepository<OrderDetail,String> {
    List<OrderDetail> findByOrOrderId(String orderId);
}
