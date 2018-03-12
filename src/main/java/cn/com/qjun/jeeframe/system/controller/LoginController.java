package cn.com.qjun.jeeframe.system.controller;

import cn.com.qjun.jeeframe.shiro.ShiroUtils;
import cn.com.qjun.jeeframe.system.utils.ValidateCodeUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author RenQiang
 * @date 2018/3/10
 */
@Controller
@RequestMapping(value = "/")
public class LoginController {

    /**
     * 登录页面
     *
     * @return
     */
    @GetMapping(value = "/login")
    public String login() {
        return "system/login";
    }

    @GetMapping(value = "validateCode.jpg")
    public void validateCode(@RequestParam(value = "width", defaultValue = "200") int width, @RequestParam(name = "height", defaultValue = "60") int height, @RequestParam(name = "length", defaultValue = "6") int length, HttpServletResponse response) {
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");

        String validateCode = ValidateCodeUtil.generateVerifyCode(length);
        ShiroUtils.sessionSet("validateCode", validateCode);
        try {
            ValidateCodeUtil.outputImage(width, height, response.getOutputStream(), validateCode);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
