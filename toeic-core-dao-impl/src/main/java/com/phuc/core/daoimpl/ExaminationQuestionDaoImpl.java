package com.phuc.core.daoimpl;

import com.phuc.core.dao.ExaminationQuestionDao;
import com.phuc.core.data.daoimpl.AbstractDao;
import com.phuc.core.persistence.entity.ExaminationQuestionEntity;

import java.util.Map;

public class ExaminationQuestionDaoImpl extends AbstractDao<Integer, ExaminationQuestionEntity> implements ExaminationQuestionDao {
    public Object[] findByProperty(Map<String, Object> property, String sortExpression, String sortDirection, Integer offset, Integer limit, Integer examinationId) {
        String whereClause = null;
        if (examinationId != null) {
            whereClause = " AND examination.examinationId = "+examinationId+"";
        }
        return super.findByProperty(property, sortExpression, sortDirection, offset, limit, whereClause);
    }
}
