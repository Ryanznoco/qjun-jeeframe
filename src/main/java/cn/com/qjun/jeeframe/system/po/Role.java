package cn.com.qjun.jeeframe.system.po;

import cn.com.qjun.jeeframe.core.po.DataEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * 系统角色实体类
 *
 * @author RenQiang
 * @date 2018/3/9
 */
@Getter
@Setter
@Entity
@Table(name = "SYS_ROLE")
public class Role extends DataEntity {
    /**
     * 数据权限范围-所有数据
     */
    private static final Byte DATA_SCOPE_ALL = 1;
    /**
     * 数据权限范围-所在公司即以下数据
     */
    private static final Byte DATA_SCOPE_COMPANY_BELOW = 2;
    /**
     * 所在公司数据
     */
    private static final Byte DATA_SCOPE_COMPANY = 3;
    /**
     * 所在部门数据及以下数据
     */
    private static final Byte DATA_SCOPE_DEPARTMENT_BELOW = 4;
    /**
     * 所在部门数据
     */
    private static final Byte DATA_SCOPE_DEPARTMENT = 5;
    /**
     * 仅本人数据
     */
    private static final Byte DATA_SCOPE_SELF = Byte.MAX_VALUE;
    /**
     * 自定义设置
     */
    private static final Byte DATA_SCOPE_CUSTOM = 0;

    /**
     * 角色名称
     */
    @Column(name = "NAME", length = 100, nullable = false)
    private String name;
    /**
     * 角色描述
     */
    @Column(name = "DESCRIPTION", length = 200)
    private String description;
    /**
     * 数据权限范围
     * 应保持值越大权限范围越小
     */
    @Column(name = "DATA_SCOPE", nullable = false)
    private Byte dataScope;
    /**
     * 所属组织机构
     */
    @JoinColumn(name = "ORG_ID")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Organization organization;
}
