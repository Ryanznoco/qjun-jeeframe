package cn.com.qjun.jeeframe.shiro;

import cn.com.qjun.jeeframe.core.po.BaseEntity;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

/**
 * @author RenQiang
 * @date 2018/3/10
 */
public class ShiroUtils {
    /**
     * 获得当前登录对象
     *
     * @return
     */
    public static Subject getSubject() {
        return SecurityUtils.getSubject();
    }

    /**
     * 往Session设置属性
     *
     * @param key
     * @param value
     */
    public static void sessionSet(Object key, Object value) {
        getSubject().getSession().setAttribute(key, value);
    }

    /**
     * 获取Session属性值
     *
     * @param key
     * @return
     */
    public static Object sessionGet(Object key) {
        return getSubject().getSession().getAttribute(key);
    }

    /**
     * 获取当前登录用户
     *
     * @return
     */
    public static String currentUserId() {
        return ((BaseEntity) getSubject().getPrincipal()).getId();
    }
}
