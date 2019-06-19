package com.phuc.command;

import com.phuc.core.dto.UserDTO;
import com.phuc.core.web.command.AbstractCommand;

public class UserCommand extends AbstractCommand<UserDTO> {
    private String confirmPassword;

    public UserCommand() {
        this.pojo = new UserDTO();
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
