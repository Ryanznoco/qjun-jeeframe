package cn.com.qjun.jeeframe.utils;

/**
 * @author RenQiang
 * @date 2018/3/12
 */
public class StringUtils {

    public static boolean isBlank(String str) {
        if (isNotEmpty(str)) {
            for (char c :
                    str.toCharArray()) {
                if (!Character.isWhitespace(c)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isNotBlank(String str) {
        return !isBlank(str);
    }

    public static boolean isEmpty(String str) {
        return str == null || "".equals(str);
    }

    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }
}
