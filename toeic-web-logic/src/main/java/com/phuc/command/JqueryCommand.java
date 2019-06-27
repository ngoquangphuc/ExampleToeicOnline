package com.phuc.command;

import com.phuc.core.dto.JqueryDTO;
import com.phuc.core.web.command.AbstractCommand;

public class JqueryCommand extends AbstractCommand<JqueryDTO> {
    public JqueryCommand() {
        this.pojo = new JqueryDTO();
    }
    private String urlType;

    public String getUrlType() {
        return urlType;
    }

    public void setUrlType(String urlType) {
        this.urlType = urlType;
    }
}
