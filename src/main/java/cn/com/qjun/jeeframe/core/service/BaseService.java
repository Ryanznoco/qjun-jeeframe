package cn.com.qjun.jeeframe.core.service;

import cn.com.qjun.jeeframe.core.po.BaseEntity;
import org.springframework.data.domain.Example;

import java.util.List;

/**
 * @author RenQiang
 * @date 2018/3/9
 */
public interface BaseService<E extends BaseEntity> {

    /**
     * 根据ID查询
     *
     * @param id
     * @return
     */
    E get(String id);

    /**
     * 根据实体案例查询单个实体，值匹配方式为“=”，条件组合方式为“and”
     *
     * @param entity
     * @return
     */
    E getByEntity(E entity);

    /**
     * 根据Example查询单个实体
     *
     * @param example
     * @return
     */
    E getByExample(Example<E> example);

    /**
     * 根据实体案例查询列表，值匹配方式为“=”，条件组合方式为“and”
     *
     * @param entity
     * @return
     */
    List<E> findByEntity(E entity);

    /**
     * 根据Example查询列表
     *
     * @param example
     * @return
     */
    List<E> findByExample(Example<E> example);

    /**
     * 保存一个实体
     *
     * @param e
     * @return
     */
    E save(E e);

    /**
     * 保存多个实体
     *
     * @param entities
     * @return
     */
    List<E> saveAll(Iterable<E> entities);

    /**
     * 根据ID删除实体
     *
     * @param id
     */
    void delete(String id);

    /**
     * 删除一个实体
     *
     * @param entity
     */
    void delete(E entity);

    /**
     * 删除多个实体
     *
     * @param entities
     */
    void deleteAll(Iterable<E> entities);
}
