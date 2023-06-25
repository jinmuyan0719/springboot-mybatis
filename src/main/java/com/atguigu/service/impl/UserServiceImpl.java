package com.atguigu.service.impl;

import com.atguigu.dao.UserDao;
import com.atguigu.domain.User;
import com.atguigu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    //@Autowired //Spring提供。依赖注入。先按照bytype,再按照byname
    @Resource  // JDK提供。依赖注入。先按照byname,再按照bytype
    UserDao userDao;

    //@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT)
    //@Transactional(readOnly = true)
    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }
}
