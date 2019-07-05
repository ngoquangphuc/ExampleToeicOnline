package com.phuc.core.service.impl;

import com.phuc.core.dto.ExaminationDTO;
import com.phuc.core.persistence.entity.ExaminationEntity;
import com.phuc.core.service.ExaminationService;
import com.phuc.core.service.utils.SingletonDaoUtil;
import com.phuc.core.utils.ExaminationBeanUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExaminationServiceImpl implements ExaminationService {
    public Object[] findExaminationByProperties(Map<String, Object> property, String sortExpression, String sortDirection, Integer offset, Integer limit) {
        List<ExaminationDTO> result = new ArrayList<ExaminationDTO>();
        Object[] objects = SingletonDaoUtil.getExaminationDaoInstance().findByProperty(property, sortExpression, sortDirection, offset, limit, null);
        for (ExaminationEntity item : (List<ExaminationEntity>) objects[1]) {
            ExaminationDTO dto = ExaminationBeanUtil.entity2Dto(item);
            result.add(dto);
        }
        objects[1] = result;
        return objects;
    }
}
