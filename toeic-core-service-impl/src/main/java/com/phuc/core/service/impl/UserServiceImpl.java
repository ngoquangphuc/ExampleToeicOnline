package com.phuc.core.service.impl;

import com.phuc.core.dao.UserDao;
import com.phuc.core.daoimpl.UserDaoImpl;
import com.phuc.core.dto.CheckLogin;
import com.phuc.core.dto.UserDTO;

import com.phuc.core.dto.UserImportDTO;
import com.phuc.core.persistence.entity.RoleEntity;
import com.phuc.core.persistence.entity.UserEntity;
import com.phuc.core.service.RoleService;
import com.phuc.core.service.UserService;
import com.phuc.core.service.utils.SingletonDaoUtil;
import com.phuc.core.utils.UserBeanUtil;
import org.apache.commons.lang.StringUtils;

import java.sql.Timestamp;
import java.util.*;

public class UserServiceImpl implements UserService {
    public Object[] findByProperty(Map<String, Object> property, String sortExpression, String sortDirection, Integer offset, Integer limit) {
        Object[] objects = SingletonDaoUtil.getUserDaoInstance().findByProperty(property, sortExpression, sortDirection, offset, limit, null);
        List<UserDTO> userDTOS = new ArrayList<UserDTO>();
        for (UserEntity item: (List<UserEntity>)objects[1]) {
            UserDTO userDTO = UserBeanUtil.entity2Dto(item);
            userDTOS.add(userDTO);
        }
        objects[1] = userDTOS;
        return objects;
    }

    public UserDTO findById(Integer userId) {
        UserEntity userEntity = SingletonDaoUtil.getUserDaoInstance().findById(userId);
        UserDTO dto = UserBeanUtil.entity2Dto(userEntity);
        return dto;
    }

    public void saveUser(UserDTO userDTO) {
        Timestamp createdDate =  new Timestamp(System.currentTimeMillis());
        userDTO.setCreatedDate(createdDate);
        UserEntity entity = UserBeanUtil.dto2Entity(userDTO);
        SingletonDaoUtil.getUserDaoInstance().save(entity);
    }

    public UserDTO updateUser(UserDTO userDTO) {
        UserEntity entity = UserBeanUtil.dto2Entity(userDTO);
        entity = SingletonDaoUtil.getUserDaoInstance().update(entity);
        userDTO = UserBeanUtil.entity2Dto(entity);
        return userDTO;
    }

    public CheckLogin checkLogin(String name, String password) {
        CheckLogin checkLogin = new CheckLogin();
        if (name != null && password != null) {
            Object[] objects = SingletonDaoUtil.getUserDaoInstance().checkLogin(name, password);
            checkLogin.setUserExist((Boolean) objects[0]);
            if (checkLogin.isUserExist()) {
                checkLogin.setRoleName(objects[1].toString());
            }
        }
        return checkLogin;
    }

    public void validateImportUser(List<UserImportDTO> userImportDTOS) {
        List<String> names = new ArrayList<String>();
        List<String> roles = new ArrayList<String>();

        for (UserImportDTO item: userImportDTOS) {
            names.add(item.getName());
            if (!roles.contains(item.getRoleName())) {
                roles.add(item.getRoleName());
            }
        }

        Map<String, UserEntity> userEntityMap = new HashMap<String, UserEntity>();
        Map<String, RoleEntity> roleEntityMap = new HashMap<String, RoleEntity>();

        if (names.size() > 0) {
            List<UserEntity> userEntities = SingletonDaoUtil.getUserDaoInstance().findByUserAdd(names);
            for (UserEntity item: userEntities) {
                userEntityMap.put(item.getName().toUpperCase(), item);
            }
        }
        if (roles.size() > 0) {
            List<RoleEntity> roleEntities = SingletonDaoUtil.getRoleDaoInstance().findByRoles(roles);
            for (RoleEntity item: roleEntities) {
                roleEntityMap.put(item.getName().toUpperCase(), item);

            }
        }
        for (UserImportDTO item: userImportDTOS) {
            String message = item.getError();
            if (item.isValid()) {
                UserEntity userEntity = userEntityMap.get(item.getName().toUpperCase());
                if (userEntity != null) {
                    message += "<br/>";
                    message += "Tên đăng nhập tồn tại";
                }
                RoleEntity roleEntity = roleEntityMap.get(item.getRoleName().toUpperCase());
                if (roleEntity == null) {
                    message += "<br/>";
                    message += "Vai trò không tồn tại";
                }
                if (StringUtils.isNotBlank(message)) {
                    item.setValid(false);
                    item.setError(message.substring(5));
                }

            }
        }
    }

    public void saveUserImport(List<UserImportDTO> userImportDTOS) {
        for (UserImportDTO item: userImportDTOS) {
            if (item.isValid()) {
                UserEntity userEntity = new UserEntity();
                userEntity.setName(item.getName());
                userEntity.setFullName(item.getFullName());
                userEntity.setPassword(item.getPassword());
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                userEntity.setCreatedDate(timestamp);
                RoleEntity roleEntity = SingletonDaoUtil.getRoleDaoInstance().findEqualUnique("name", item.getRoleName().toUpperCase());
                userEntity.setRoleEntity(roleEntity);
                SingletonDaoUtil.getUserDaoInstance().save(userEntity);
            }
        }
    }
}
