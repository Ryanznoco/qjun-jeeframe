package cn.com.qjun.jeeframe.system.service.impl;

import cn.com.qjun.jeeframe.core.service.impl.BaseServiceImpl;
import cn.com.qjun.jeeframe.system.po.User;
import cn.com.qjun.jeeframe.system.repository.UserRepository;
import cn.com.qjun.jeeframe.system.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author RenQiang
 * @date 2018/3/10
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class UserServiceImpl extends BaseServiceImpl<User, UserRepository> implements UserService {
}
