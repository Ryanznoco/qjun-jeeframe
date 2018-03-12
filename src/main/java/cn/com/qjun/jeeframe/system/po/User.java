package cn.com.qjun.jeeframe.system.po;

import cn.com.qjun.jeeframe.core.po.DataEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * 系统用户实体类
 *
 * @author RenQiang
 * @date 2018/3/9
 */
@Getter
@Setter
@Entity
@Table(name = "SYS_USER")
public class User extends DataEntity {
    /**
     * 姓名
     */
    @Column(name = "NAME", nullable = false, length = 50)
    private String name;
    /**
     * 登录名
     */
    @Column(name = "LOGIN_NAME", length = 50, nullable = false, unique = true)
    private String loginName;
    /**
     * 登录密码
     */
    @Column(name = "PASSWORD", length = 32, nullable = false)
    private String password;
    /**
     * 手机号码
     */
    @Column(name = "MOBILE", length = 11, unique = true)
    private String mobile;
    /**
     * 所属组织机构
     */
    @JoinColumn(name = "ORG_ID")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Organization organization;
    /**
     * 拥有的角色列表
     */
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "SYS_USER_ROLE", joinColumns = {
            @JoinColumn(name = "USER_ID")
    }, inverseJoinColumns = {
            @JoinColumn(name = "ROLE_ID")
    })
    private List<Role> roles;
}
