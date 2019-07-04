package com.phuc.command;

import com.phuc.core.dto.ResultDTO;
import com.phuc.core.web.command.AbstractCommand;

public class ResultCommand extends AbstractCommand<ResultDTO> {
    public ResultCommand() {
        this.pojo = new ResultDTO();
    }
}
