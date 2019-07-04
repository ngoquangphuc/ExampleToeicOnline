package com.phuc.command;

import com.phuc.core.dto.ExerciseDTO;
import com.phuc.core.web.command.AbstractCommand;

public class ExerciseCommand extends AbstractCommand<ExerciseDTO> {
    public ExerciseCommand() {
        this.pojo = new ExerciseDTO();
    }
}
