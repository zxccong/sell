package peason.zxc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import peason.zxc.dataobject.ProductInfo;
import peason.zxc.enums.ProductStatusEnum;
import peason.zxc.repository.ProductInfoRepository;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductInfoRepository repository;

    public ProductInfo findOne(String productId){
        return repository.findById(productId).get();
    }

    public Page<ProductInfo> findAll(Pageable pageable){
        return repository.findAll(pageable);
    }

    public List<ProductInfo> findUpAll(){
        return repository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    public ProductInfo save(ProductInfo productInfo){
        return repository.save(productInfo);
    }
}
