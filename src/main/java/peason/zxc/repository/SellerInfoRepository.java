package peason.zxc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import peason.zxc.dataobject.SellerInfo;

public interface SellerInfoRepository extends JpaRepository<SellerInfo, String> {
    SellerInfo findByOpenid(String openid);
    SellerInfo findByUsername(String userName);
}
