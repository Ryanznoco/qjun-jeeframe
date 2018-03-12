package cn.com.qjun.jeeframe.utils;

import org.apache.shiro.codec.Hex;

/**
 * @author RenQiang
 * @date 2018/3/12
 */
public class CodeUtils {

    /**
     * HEX编码
     *
     * @param source
     * @return
     */
    public static String encodeHex(byte[] source) {
        return Hex.encodeToString(source);
    }

    /**
     * HEX解码
     *
     * @param hex
     * @return
     */
    public static byte[] decodeHex(String hex) {
        return Hex.decode(hex);
    }
}
