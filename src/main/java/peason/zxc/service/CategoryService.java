package peason.zxc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peason.zxc.dataobject.ProductCategory;
import peason.zxc.repository.ProductCategoryRepository;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private ProductCategoryRepository repository;

    public ProductCategory findOne(Integer categoryId){
        return repository.findById(categoryId).get();
    }

    public List<ProductCategory> findAll(){
        return repository.findAll();
    }

    public List<ProductCategory> findByCategoryTypeIn(List<Integer> category){
        return repository.findByCategoryTypeIn(category);
    }

    public ProductCategory save(ProductCategory productCategory){
        return repository.save(productCategory);
    }

}
