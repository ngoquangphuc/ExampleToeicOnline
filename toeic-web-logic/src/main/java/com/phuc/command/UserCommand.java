package com.phuc.command;

import com.phuc.core.dto.UserDTO;
import com.phuc.core.web.command.AbstractCommand;

public class UserCommand extends AbstractCommand<UserDTO> {
    public UserCommand() {
        this.pojo = new UserDTO();
    }
}
