package cn.com.qjun.jeeframe.shiro;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 *
 * @author RenQiang
 * @date 2018/3/12
 */
@Getter
@Setter
public class UserPrincipal implements Serializable {
    private String id;
    private String loginName;
    private String name;
}
