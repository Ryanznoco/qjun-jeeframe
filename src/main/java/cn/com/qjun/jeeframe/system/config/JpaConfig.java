package cn.com.qjun.jeeframe.system.config;

import cn.com.qjun.jeeframe.system.po.User;
import cn.com.qjun.jeeframe.system.repository.UserRepository;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author RenQiang
 * @date 2018/3/10
 */
@Configuration
@EnableTransactionManagement
@EntityScan(basePackageClasses = {User.class})
@EnableJpaRepositories(basePackageClasses = {UserRepository.class})
public class JpaConfig {
}
