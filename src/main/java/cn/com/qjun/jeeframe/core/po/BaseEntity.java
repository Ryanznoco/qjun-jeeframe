package cn.com.qjun.jeeframe.core.po;

import cn.com.qjun.jeeframe.core.constant.SysConstant;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @author RenQiang
 * @date 2018/3/9
 */
@Getter
@Setter
@MappedSuperclass
@Inheritance(strategy = InheritanceType.JOINED)
public class BaseEntity {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "ID", length = SysConstant.ID_LENGTH, updatable = false)
    private String id;

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        return ((BaseEntity) obj).getId().equals(this.getId());
    }
}
