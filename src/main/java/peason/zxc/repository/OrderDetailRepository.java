package peason.zxc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import peason.zxc.dataobject.orderDetail;

import java.util.List;

public interface OrderDetailRepository extends JpaRepository<orderDetail,String> {
    List<orderDetail> findByOrOrderId(String orderId);
}
