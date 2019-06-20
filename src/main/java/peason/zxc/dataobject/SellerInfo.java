package peason.zxc.dataobject;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 卖家信息表
 * </p>
 *
 * @author zxccong
 * @since 2019-06-20
 */
@Entity
@Data
@DynamicUpdate
public class SellerInfo {

    @Id
    private String id;

    private String username;

    private String password;
    /**
     * 微信openid
     */
    private String openid;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date updateTime;

}
