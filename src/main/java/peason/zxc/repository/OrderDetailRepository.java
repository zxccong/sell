package peason.zxc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import peason.zxc.dataobject.OrderDetial;

import java.util.List;

public interface OrderDetailRepository extends JpaRepository<OrderDetial,String> {
    List<OrderDetial> findByOrOrderId(String orderId);
}
