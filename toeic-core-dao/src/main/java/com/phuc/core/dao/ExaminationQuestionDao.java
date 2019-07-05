package com.phuc.core.dao;

import com.phuc.core.data.dao.GenericDao;
import com.phuc.core.persistence.entity.ExaminationQuestionEntity;

import java.util.Map;

public interface ExaminationQuestionDao extends GenericDao<Integer, ExaminationQuestionEntity> {
    Object[] findByProperty(Map<String, Object> property, String sortExpression, String sortDirection, Integer offset, Integer limit, Integer examinationId);

}
