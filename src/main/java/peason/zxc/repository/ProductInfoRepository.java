package peason.zxc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import peason.zxc.dataobject.ProductInfo;

import java.util.List;

public interface ProductInfoRepository extends JpaRepository<ProductInfo,String> {

    List<ProductInfo> findByProductStatus(Integer productStatus);
}
