package com.phuc.core.dao;

import com.phuc.core.data.dao.GenericDao;
import com.phuc.core.persistence.entity.RoleEntity;

import java.util.List;

public interface RoleDao extends GenericDao<Integer, RoleEntity> {
    List<RoleEntity> findByRoles(List<String> roles);

}
