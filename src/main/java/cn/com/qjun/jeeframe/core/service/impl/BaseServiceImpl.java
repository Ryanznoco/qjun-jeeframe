package cn.com.qjun.jeeframe.core.service.impl;

import cn.com.qjun.jeeframe.core.po.BaseEntity;
import cn.com.qjun.jeeframe.core.repository.BaseRepository;
import cn.com.qjun.jeeframe.core.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author RenQiang
 * @date 2018/3/9
 */
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class BaseServiceImpl<E extends BaseEntity, R extends BaseRepository> implements BaseService<E> {
    @Autowired
    private R repository;

    @Override
    public E get(String id) {
        return (E) repository.getOne(id);
    }

    @Override
    public E getByEntity(E entity) {
        Example<E> example = Example.of(entity);
        return (E) repository.findOne(example).orElse(null);
    }

    @Override
    public E getByExample(Example<E> example) {
        return (E) repository.findOne(example).orElse(null);
    }

    @Override
    public List<E> findByEntity(E entity) {
        Example<E> example = Example.of(entity);
        return repository.findAll(example);
    }

    @Override
    public List<E> findByExample(Example<E> example) {
        return repository.findAll(example);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public E save(E e) {
        return (E) repository.save(e);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<E> saveAll(Iterable<E> entities) {
        return repository.saveAll(entities);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(String id) {
        repository.deleteById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(E entity) {
        repository.delete(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteAll(Iterable<E> entities) {
        repository.deleteInBatch(entities);
    }
}
