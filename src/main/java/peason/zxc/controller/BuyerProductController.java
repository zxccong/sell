package peason.zxc.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import peason.zxc.dataobject.ProductCategory;
import peason.zxc.dataobject.ProductInfo;
import peason.zxc.service.CategoryService;
import peason.zxc.service.ProductService;
import peason.zxc.utils.ResultVoUtils;
import peason.zxc.vo.ProductInfoVo;
import peason.zxc.vo.ProductVo;
import peason.zxc.vo.ResultVo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 买家商品
 */
@RestController
@RequestMapping("buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public ResultVo list(){
        //1.查询所有的上架商品
        List<ProductInfo> productInfoList = productService.findUpAll();
        //2.查询类目（一次性查询）
//        //统计类目

        //jdk8新方法统计类目
        List<Integer> categoryTypeList = productInfoList.stream().map(e -> e.getCategoryType()).collect(Collectors.toList());
        List<ProductCategory> categoriesList = categoryService.findByCategoryTypeIn(categoryTypeList);

        //3.数据拼接
        ArrayList<ProductVo> productVos = new ArrayList<>();
        //遍历类别
        for (ProductCategory productCategory:categoriesList) {
            ProductVo productVo = new ProductVo();
            //设置类目名字
            productVo.setCategoryName(productCategory.getCategoryName());
            //设置类目的类型
            productVo.setCategoryType(productCategory.getCategoryType());
            List<ProductInfoVo> productInfoVoList = new ArrayList<>();
            for (ProductInfo productInfo: productInfoList) {
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                    ProductInfoVo productInfoVo = new ProductInfoVo();
                    BeanUtils.copyProperties(productInfo,productInfoVo);
                    productInfoVoList.add(productInfoVo);
                }
            }
            productVo.setProductInfoVoList(productInfoVoList);
            productVos.add(productVo);
        }
        return ResultVoUtils.success(productVos);
    }


}
