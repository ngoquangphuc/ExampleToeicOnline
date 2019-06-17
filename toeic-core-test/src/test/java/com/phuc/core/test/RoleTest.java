package com.phuc.core.test;

import com.phuc.core.dao.RoleDao;
import com.phuc.core.daoimpl.RoleDaoImpl;
import com.phuc.core.persistence.entity.RoleEntity;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class RoleTest {
    @Test
    public void checkFindAll() {
        RoleDao roleDao = new RoleDaoImpl();
        List<RoleEntity> list = roleDao.findAll();
    }

    @Test
    public void checkUpdateRole() {
        RoleDao roleDao = new RoleDaoImpl();
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setRoleId(2);
        roleEntity.setName("USER");
        roleDao.update(roleEntity);
    }

    @Test
    public void checkSaveRole() {
        RoleDao roleDao = new RoleDaoImpl();
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setRoleId(1);
        roleEntity.setName("ADMIN");
        RoleEntity roleEntity1 = new RoleEntity();
        roleEntity1.setRoleId(2);
        roleEntity1.setName("USER");
        roleDao.update(roleEntity);
        roleDao.update(roleEntity1);
    }

    @Test
    public void checkFindById() {
        RoleDao roleDao = new RoleDaoImpl();
        RoleEntity roleEntity = roleDao.findById(1);
    }

    @Test
    public void checkFindByProperty() {
        RoleDao roleDao = new RoleDaoImpl();
        String property = null;
        Object value = null;
        String sortExpression = null;
        String sortDirection = null;
        Object[] objects = roleDao.findByProperty(property, value, sortExpression, sortDirection);
    }

    @Test
    public void checkDelete() {
        List<Integer> listId = new ArrayList<Integer>();
        listId.add(1);
        listId.add(2);
        RoleDao roleDao = new RoleDaoImpl();
        Integer count = roleDao.delete(listId);
    }
}
