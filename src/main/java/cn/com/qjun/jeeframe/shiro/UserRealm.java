package cn.com.qjun.jeeframe.shiro;

import cn.com.qjun.jeeframe.system.po.User;
import cn.com.qjun.jeeframe.system.service.UserService;
import cn.com.qjun.jeeframe.utils.CodeUtils;
import cn.com.qjun.jeeframe.utils.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author RenQiang
 * @date 2018/3/10
 */
public class UserRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        if (StringUtils.isNotBlank(token.getUsername()) && StringUtils.isNotBlank(String.copyValueOf(token.getPassword()))) {
            User user = userService.getByLoginName(token.getUsername());
            if (user == null) {
                throw new UnknownAccountException("Login name doesn't exists: " + token.getUsername());
            }
            return new SimpleAuthenticationInfo(user, user.getPassword(), ByteSource.Util.bytes(CodeUtils.decodeHex(user.getPassword().substring(0, 18))), getName());
        }
        return null;
    }
}
