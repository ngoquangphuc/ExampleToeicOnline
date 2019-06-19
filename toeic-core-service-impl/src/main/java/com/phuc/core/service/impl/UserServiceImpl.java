package com.phuc.core.service.impl;

import com.phuc.core.dao.UserDao;
import com.phuc.core.daoimpl.UserDaoImpl;
import com.phuc.core.dto.UserDTO;

import com.phuc.core.persistence.entity.UserEntity;
import com.phuc.core.service.UserService;
import com.phuc.core.utils.UserBeanUtil;

public class UserServiceImpl implements UserService {
    public UserDTO isUserExist(UserDTO dto) {
        UserDao userDao =  new UserDaoImpl();
        UserEntity entity =  userDao.isUserExist(dto.getName(), dto.getPassword());
        return UserBeanUtil.entity2Dto(entity);
    }

    public UserDTO findRoleByUser(UserDTO dto) {
        UserDao userDao =  new UserDaoImpl();
        UserEntity entity =  userDao.findRoleByUser(dto.getName(), dto.getPassword());
        return UserBeanUtil.entity2Dto(entity);
    }
}
