package com.phuc.core.service;

import com.phuc.core.dto.ExaminationQuestionDTO;
import com.phuc.core.dto.ResultDTO;

import java.util.List;

public interface ResultService {
    ResultDTO saveResult(String userName, Integer examinationId, List<ExaminationQuestionDTO> examinationQuestions);
}
