package com.phuc.core.service.impl;

import com.phuc.core.dao.RoleDao;
import com.phuc.core.daoimpl.RoleDaoImpl;
import com.phuc.core.dto.RoleDTO;
import com.phuc.core.persistence.entity.RoleEntity;
import com.phuc.core.service.RoleService;
import com.phuc.core.utils.RoleBeanUtil;

import java.util.ArrayList;
import java.util.List;

public class RoleServiceImpl implements RoleService {
    RoleDao roleDao = new RoleDaoImpl();

    public List<RoleDTO> findAll() {
        List<RoleEntity> entities = roleDao.findAll();
        List<RoleDTO> dtos = new ArrayList<RoleDTO>();
        for (RoleEntity item : entities) {
            RoleDTO dto = RoleBeanUtil.entity2Dto(item);
            dtos.add(dto);
        }
        return dtos;
    }
}
