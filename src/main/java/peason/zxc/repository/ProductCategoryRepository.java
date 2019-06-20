package peason.zxc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import peason.zxc.dataobject.ProductCategory;

import java.util.List;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer> {
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
