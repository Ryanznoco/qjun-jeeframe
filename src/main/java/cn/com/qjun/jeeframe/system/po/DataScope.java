package cn.com.qjun.jeeframe.system.po;

import cn.com.qjun.jeeframe.core.po.DataEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 角色数据权限设置明细
 * 当角色数据权限范围为自定义设置的时候，可以自定义设置其可管的人和可管的组织机构
 *
 * @author RenQiang
 * @date 2018/3/10
 */
@Getter
@Setter
@Entity
@Table(name = "SYS_DATA_SCOPE")
public class DataScope extends DataEntity {
    /**
     * 可管数据范围-人
     * 用于自定设置角色可管的人
     */
    private Character SCOPE_USER = '1';
    /**
     * 可管数据范围-组织机构
     * 用于自定义设置角色可管的组织机构
     */
    private Character SCOPE_ORG = '2';

    /**
     * 可管数据范围
     */
    @Column(name = "SCOPE", nullable = false)
    private Character scope;
    /**
     * 角色ID
     */
    @Column(name = "ROLE_ID", nullable = false)
    private String roleId;
    /**
     * 关联数据ID
     */
    @Column(name = "TARGET_ID", nullable = false)
    private String targetId;
}
