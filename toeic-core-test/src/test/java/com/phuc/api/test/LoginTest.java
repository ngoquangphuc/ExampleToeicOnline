package com.phuc.api.test;


import com.phuc.core.dao.UserDao;
import com.phuc.core.daoimpl.UserDaoImpl;
import com.phuc.core.persistence.entity.UserEntity;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class LoginTest {
    private final Logger log = Logger.getLogger(this.getClass());

    @Test
    public void checkIsUserExist() {
        UserDao userDao = new UserDaoImpl();
        String name = "ngoquangphuc";
        String password = "123456";
        UserEntity entity = userDao.isUserExist(name, password);
        if (entity != null) {
            log.error("Login success");
        } else {
            log.error("Login fail");
        }
    }

    @Test
    public void checkFindRoleByUser() {
        UserDao userDao = new UserDaoImpl();
        String name = "ngoquangphuc";
        String password = "123456";
        UserEntity entity = userDao.findRoleByUser(name, password);
        log.error(entity.getRoleEntity().getRoleId() + "-" + entity.getRoleEntity().getName());
    }
}
