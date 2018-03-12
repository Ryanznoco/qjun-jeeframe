package cn.com.qjun.jeeframe.core.repository;

import cn.com.qjun.jeeframe.core.po.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @author RenQiang
 * @date 2018/3/9
 */
@NoRepositoryBean
public interface BaseRepository<E extends BaseEntity> extends JpaRepository<E, String>, JpaSpecificationExecutor<E> {
}
