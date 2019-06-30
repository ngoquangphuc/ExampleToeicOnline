package com.phuc.core.dao;

import com.phuc.core.data.dao.GenericDao;
import com.phuc.core.persistence.entity.UserEntity;

import java.util.List;

public interface UserDao extends GenericDao<Integer, UserEntity> {
    Object[] checkLogin(String name, String password);
    List<UserEntity> findByUserAdd(List<String> names);
}
