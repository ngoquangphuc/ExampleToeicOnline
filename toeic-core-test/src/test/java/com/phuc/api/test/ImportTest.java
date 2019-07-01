package com.phuc.api.test;

import com.phuc.core.dao.RoleDao;
import com.phuc.core.daoimpl.RoleDaoImpl;
import com.phuc.core.persistence.entity.RoleEntity;
import org.testng.annotations.Test;

public class ImportTest {
    @Test
    public void testImport() {
        RoleDao roleDao = new RoleDaoImpl();
        RoleEntity entity = roleDao.findEqualUnique("name", "USER");
        System.out.println(entity.getName());
    }
}
