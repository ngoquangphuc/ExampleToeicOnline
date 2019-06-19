package com.phuc.core.dao;

import com.phuc.core.data.dao.GenericDao;
import com.phuc.core.persistence.entity.UserEntity;

public interface UserDao extends GenericDao<Integer, UserEntity> {
    UserEntity isUserExist(String name, String password);
    UserEntity findRoleByUser(String name, String password);
}
