package com.phuc.command;

import com.phuc.core.dto.ListenGuidelineDTO;
import com.phuc.core.web.command.AbstractCommand;

public class ListenGuidelineCommand extends AbstractCommand<ListenGuidelineDTO> {
    public ListenGuidelineCommand() {
        this.pojo = new ListenGuidelineDTO();
    }
}
