package peason.zxc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import peason.zxc.dataobject.ProductInfo;
import peason.zxc.dto.CartDto;
import peason.zxc.enums.ProductStatusEnum;
import peason.zxc.enums.ResultEnum;
import peason.zxc.exception.SellException;
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

    //加库存
    public void increaseStock(List<CartDto> cartDtoList){
        for (CartDto cartDto : cartDtoList) {
            ProductInfo productInfo = this.findOne(cartDto.getProductId());
            //判断商品是否存在
            if (productInfo ==null){
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }

            int result = productInfo.getProductStock() + cartDto.getProductQuantity();

            productInfo.setProductStock(result);

            this.save(productInfo);

        }
    }

    //减库存
    public void decreaseStock(List<CartDto> cartDtoList){
        for (CartDto cartDto : cartDtoList) {
            ProductInfo productInfo = this.findOne(cartDto.getProductId());
            //判断商品是否存在
            if (productInfo ==null){
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }

            int result = productInfo.getProductStock() - cartDto.getProductQuantity();
            if (result<0){
                throw new SellException(ResultEnum.PRODUCT_STOCK_ERROR);
            }
            productInfo.setProductStock(result);

            this.save(productInfo);

        }
    }
}
