package com.phuc.core.service;

import com.phuc.core.dto.CheckLogin;
import com.phuc.core.dto.UserDTO;

import java.util.Map;

public interface UserService {
    Object[] findByProperty(Map<String, Object> property, String sortExpression, String sortDirection, Integer offset, Integer limit);
    UserDTO findById(Integer userId);
    void saveUser(UserDTO userDTO);
    UserDTO updateUser(UserDTO userDTO);
    CheckLogin checkLogin(String name, String password);
}
