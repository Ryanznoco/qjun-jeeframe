package cn.com.qjun.jeeframe.shiro.config;

import cn.com.qjun.jeeframe.shiro.ShiroUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.auditing.DateTimeProvider;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.time.ZonedDateTime;
import java.util.Optional;

/**
 * @author RenQiang
 * @date 2018/3/10
 */
@Configuration
@EnableJpaAuditing
public class AuditingConfig {

    @Bean
    AuditorAware<String> auditorProvider() {
        return () -> Optional.of(ShiroUtils.currentUserId());
    }

    @Bean
    DateTimeProvider dateTimeProvider() {
        return () -> Optional.of(ZonedDateTime.now());
    }
}
