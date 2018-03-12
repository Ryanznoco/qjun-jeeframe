package cn.com.qjun.jeeframe.core.po;

import cn.com.qjun.jeeframe.core.constant.SysConstant;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * @author RenQiang
 * @date 2018/3/9
 */
@Getter
@Setter
@MappedSuperclass
@Inheritance(strategy = InheritanceType.JOINED)
@EntityListeners(AuditingEntityListener.class)
public class DataEntity extends BaseEntity {
    /**
     * 正常
     */
    public static final Character FLAG_NORMAL = '1';
    /**
     * 已删除
     */
    public static final Character FLAG_DELETED = '0';
    /**
     * 未审核
     */
    public static final Character FLAG_UNCHECK = '2';

    public DataEntity() {
        this.setFlag(DataEntity.FLAG_NORMAL);
    }

    /**
     * 创建人ID
     */
    @CreatedBy
    @Column(name = "CREATE_BY", length = SysConstant.ID_LENGTH, nullable = false, updatable = false)
    private String createBy;
    /**
     * 创建时间
     */
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATE_DATE", nullable = false, updatable = false)
    private Date createDate;
    /**
     * 最后修改人ID
     */
    @LastModifiedBy
    @Column(name = "MODIFIED_BY", length = SysConstant.ID_LENGTH)
    private String modifiedBy;
    /**
     * 最后修改时间
     */
    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "MODIFIED_DATE")
    private Date modifiedDate;
    /**
     * 标志字段，1-正常，0-删除，2-未审核
     */
    @Column(name = "FLAG", nullable = false)
    private Character flag;
}
