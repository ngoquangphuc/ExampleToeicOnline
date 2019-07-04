package com.phuc.command;

import com.phuc.core.dto.ExaminationDTO;
import com.phuc.core.web.command.AbstractCommand;

public class ExaminationCommand extends AbstractCommand<ExaminationDTO> {
    public ExaminationCommand() {
        this.pojo = new ExaminationDTO();
    }
}
