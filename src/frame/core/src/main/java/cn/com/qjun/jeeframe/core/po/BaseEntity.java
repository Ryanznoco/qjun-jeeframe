package cn.com.qjun.jeeframe.core.po;

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
@Entity
@MappedSuperclass
@Inheritance(strategy = InheritanceType.JOINED)
public class BaseEntity {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "ID", length = 36, updatable = false)
    private String id;
}
