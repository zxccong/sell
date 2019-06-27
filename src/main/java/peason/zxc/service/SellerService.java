package peason.zxc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peason.zxc.dataobject.SellerInfo;
import peason.zxc.repository.SellerInfoRepository;

@Service
public class SellerService  {

    @Autowired
    private SellerInfoRepository repository;

    public SellerInfo findSellerInfoByOpenid(String openid) {
        return repository.findByOpenid(openid);
    }

    public SellerInfo findByUsername(String userName) {
        return repository.findByUsername(userName);
    }


}
