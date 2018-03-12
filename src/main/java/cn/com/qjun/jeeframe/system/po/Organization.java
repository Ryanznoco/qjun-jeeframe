package cn.com.qjun.jeeframe.system.po;

import cn.com.qjun.jeeframe.core.constant.SysConstant;
import cn.com.qjun.jeeframe.core.po.DataEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 组织机构实体类
 *
 * @author RenQiang
 * @date 2018/3/9
 */
@Getter
@Setter
@Entity
@Table(name = "SYS_ORG")
public class Organization extends DataEntity {
    /**
     * 组织机构类型-公司
     */
    public static final Integer TYPE_COMPANY = 1;
    /**
     * 组织机构类型-部门
     */
    public static final Integer TYPE_DEPARTMENT = 2;

    /**
     * 组织机构类型，应保持值越大规模越小
     * 可自由扩展
     */
    @Column(name = "TYPE", nullable = false)
    private Integer type;
    /**
     * 组织机构名称
     */
    @Column(name = "NAME", length = 100, nullable = false)
    private String name;
    /**
     * 上级ID
     */
    @Column(name = "PARENT_ID", length = SysConstant.ID_LENGTH)
    private String parentId;
    /**
     * 所有上级ID，逗号分隔
     */
    @Column(name = "PARENT_IDS", length = 500)
    private String parentIds;
}
