package com.phuc.core.service.impl;

import com.phuc.core.dto.ExaminationQuestionDTO;
import com.phuc.core.persistence.entity.ExaminationQuestionEntity;
import com.phuc.core.service.ExaminationQuestionService;
import com.phuc.core.service.utils.SingletonDaoUtil;
import com.phuc.core.utils.ExaminationBeanUtil;
import com.phuc.core.utils.ExaminationQuestionBeanUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExaminationQuestionServiceImpl implements ExaminationQuestionService {
    public Object[] findExaminationQuestionByProperties(Map<String, Object> property, String sortExpression, String sortDirection, Integer offset, Integer limit, Integer examinationId) {
        List<ExaminationQuestionDTO> result = new ArrayList<ExaminationQuestionDTO>();
        String whereClause = null;
        if (examinationId != null) {
            whereClause = " AND examination.examinationId = " + examinationId;
        }
        Object[] objects = SingletonDaoUtil.getExaminationQuestionDaoInstance().findByProperty(property, sortExpression, sortDirection, offset, limit, whereClause);
        int count = 1;
        for (ExaminationQuestionEntity item : (List<ExaminationQuestionEntity>) objects[1]) {
            ExaminationQuestionDTO dto = ExaminationQuestionBeanUtil.entity2Dto(item);
            if (item.getParagraph() == null) {
                dto.setNumber(count);
                count++;
            }
            dto.setExamination(ExaminationBeanUtil.entity2Dto(item.getExamination()));
            result.add(dto);
        }
        objects[1] = result;
        return objects;
    }
}
