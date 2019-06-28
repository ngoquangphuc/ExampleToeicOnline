package com.phuc.core.service.impl;

import com.phuc.core.dao.UserDao;
import com.phuc.core.daoimpl.UserDaoImpl;
import com.phuc.core.dto.UserDTO;

import com.phuc.core.persistence.entity.UserEntity;
import com.phuc.core.service.UserService;
import com.phuc.core.utils.UserBeanUtil;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {
    UserDao userDao =  new UserDaoImpl();
    public UserDTO isUserExist(UserDTO dto) {
        UserEntity entity =  userDao.findUserByUserNameAndPassword(dto.getName(), dto.getPassword());
        return UserBeanUtil.entity2Dto(entity);
    }

    public UserDTO findRoleByUser(UserDTO dto) {
        UserEntity entity =  userDao.findUserByUserNameAndPassword(dto.getName(), dto.getPassword());
        return UserBeanUtil.entity2Dto(entity);
    }

    public Object[] findByProperty(Map<String, Object> property, String sortExpression, String sortDirection, Integer offset, Integer limit) {
        Object[] objects = userDao.findByProperty(property, sortExpression, sortDirection, offset, limit);
        List<UserDTO> userDTOS = new ArrayList<UserDTO>();
        for (UserEntity item: (List<UserEntity>)objects[1]) {
            UserDTO userDTO = UserBeanUtil.entity2Dto(item);
            userDTOS.add(userDTO);
        }
        objects[1] = userDTOS;
        return objects;
    }

    public UserDTO findById(Integer userId) {
        UserEntity userEntity = userDao.findById(userId);
        UserDTO dto = UserBeanUtil.entity2Dto(userEntity);
        return dto;
    }

    public void saveUser(UserDTO userDTO) {
        Timestamp createdDate =  new Timestamp(System.currentTimeMillis());
        userDTO.setCreatedDate(createdDate);
        UserEntity entity = UserBeanUtil.dto2Entity(userDTO);
        userDao.save(entity);
    }

    public UserDTO updateUser(UserDTO userDTO) {
        UserEntity entity = UserBeanUtil.dto2Entity(userDTO);
        entity = userDao.update(entity);
        userDTO = UserBeanUtil.entity2Dto(entity);
        return userDTO;
    }
}
