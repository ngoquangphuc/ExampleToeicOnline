package com.phuc.command;

import com.phuc.core.dto.RoleDTO;
import com.phuc.core.dto.UserDTO;
import com.phuc.core.web.command.AbstractCommand;

import javax.management.relation.Role;
import java.util.List;

public class UserCommand extends AbstractCommand<UserDTO> {
    public UserCommand() {
        this.pojo = new UserDTO();
    }
    private String confirmPassword;
    private List<RoleDTO> roles;
    private Integer roleId;

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public List<RoleDTO> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleDTO> roles) {
        this.roles = roles;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}
