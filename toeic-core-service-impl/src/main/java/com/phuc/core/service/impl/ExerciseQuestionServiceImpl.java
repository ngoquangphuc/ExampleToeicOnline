package com.phuc.core.service.impl;

import com.phuc.core.dto.ExerciseQuestionDTO;
import com.phuc.core.persistence.entity.ExerciseEntity;
import com.phuc.core.persistence.entity.ExerciseQuestionEntity;
import com.phuc.core.service.ExerciseQuestionService;
import com.phuc.core.service.utils.SingletonDaoUtil;
import com.phuc.core.utils.ExerciseBeanUtil;
import com.phuc.core.utils.ExerciseQuestionBeanUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExerciseQuestionServiceImpl implements ExerciseQuestionService {
    public Object[] findExerciseQuestionByProperties(Map<String, Object> property, String sortExpression, String sortDirection, Integer offset, Integer limit, Integer exerciseId) {
        List<ExerciseQuestionDTO> result = new ArrayList<ExerciseQuestionDTO>();
        String whereClause = null;
        if (exerciseId != null) {
            whereClause = " AND exerciseEntity.exerciseId = "+exerciseId+"";
        }
        Object[] objects = SingletonDaoUtil.getExerciseQuestionDaoInstance().findByProperty(property, sortExpression, sortDirection, offset, limit);
        for (ExerciseQuestionEntity item : (List<ExerciseQuestionEntity>) objects[1]) {
            ExerciseQuestionDTO dto = ExerciseQuestionBeanUtil.entity2Dto(item);
            dto.setExercise(ExerciseBeanUtil.entity2Dto(item.getExerciseEntity()));
            result.add(dto);
        }
        objects[1] = result;
        return objects;
    }
}
