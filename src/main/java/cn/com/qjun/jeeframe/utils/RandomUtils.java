package cn.com.qjun.jeeframe.utils;

import javax.validation.constraints.AssertTrue;
import java.util.Random;

/**
 * @author RenQiang
 * @date 2018/3/12
 */
public class RandomUtils {
    private static Random random = new Random();

    /**
     * 生成指定长度的随机byte数组
     *
     * @param size 要生成的数组长度
     * @return
     */
    public byte[] nextBytes(int size) {
        byte[] result = new byte[size];
        random.nextBytes(result);
        return result;
    }
}
