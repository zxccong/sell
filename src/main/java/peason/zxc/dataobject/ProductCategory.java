package peason.zxc.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 *
 */
@Entity
@Data
@DynamicUpdate
public class ProductCategory {

    @Id //设置为id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //自增类型
    private Integer categoryId;

    private String categoryName;

    private Integer categoryType;

    private Date createTime;

    private Date updateTime;
}
