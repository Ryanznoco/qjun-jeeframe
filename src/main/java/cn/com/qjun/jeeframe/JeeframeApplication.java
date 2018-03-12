package cn.com.qjun.jeeframe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author RenQiang
 */
@SpringBootApplication
public class JeeframeApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(JeeframeApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(JeeframeApplication.class, args);
    }
}
