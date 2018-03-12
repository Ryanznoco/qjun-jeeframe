package cn.com.qjun.jeeframe;

import cn.com.qjun.jeeframe.system.utils.ValidateCodeUtil;
import junit.framework.TestCase;

import java.io.File;
import java.io.IOException;

/**
 * @author RenQiang
 * @date 2018/3/10
 */
public class MethodTest extends TestCase {

    public void testValidateCode() throws IOException {
        File dir = new File("E:/validateCodes");
        int w = 200, h = 80;
        for (int i = 0; i < 50; i++) {
            String verifyCode = ValidateCodeUtil.generateVerifyCode(4);
            File file = new File(dir, verifyCode + ".jpg");
            ValidateCodeUtil.outputImage(w, h, file, verifyCode);
        }
    }
}
