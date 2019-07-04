package com.phuc.core.service.impl;

import com.phuc.core.dto.ExerciseDTO;
import com.phuc.core.persistence.entity.ExerciseEntity;
import com.phuc.core.service.ExerciseService;
import com.phuc.core.service.utils.SingletonDaoUtil;
import com.phuc.core.utils.ExerciseBeanUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExerciseServiceImpl implements ExerciseService {
    public Object[] findExerciseByProperties(Map<String, Object> property, String sortExpression, String sortDirection, Integer offset, Integer limit) {
        List<ExerciseDTO> result = new ArrayList<ExerciseDTO>();
        Object[] objects = SingletonDaoUtil.getExerciseDaoInstance().findByProperty(property, sortExpression, sortDirection, offset, limit);
        for (ExerciseEntity item : (List<ExerciseEntity>) objects[1]) {
            ExerciseDTO dto = ExerciseBeanUtil.entity2Dto(item);
            result.add(dto);
        }
        objects[1] = result;
        return objects;
    }
}
