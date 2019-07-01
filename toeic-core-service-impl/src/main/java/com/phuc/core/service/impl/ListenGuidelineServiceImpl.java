package com.phuc.core.service.impl;

import com.phuc.core.dao.ListenGuidelineDao;
import com.phuc.core.daoimpl.ListenGuidelineDaoImpl;
import com.phuc.core.dto.ListenGuidelineDTO;
import com.phuc.core.persistence.entity.ListenGuidelineEntity;
import com.phuc.core.service.ListenGuidelineService;
import com.phuc.core.service.utils.SingletonDaoUtil;
import com.phuc.core.utils.ListenGuidelineBeanUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ListenGuidelineServiceImpl implements ListenGuidelineService {
     public Object[] findListenGuidelineByProperties(Map<String, Object> property, String sortExpression, String sortDirection, Integer offset, Integer limit) {
        List<ListenGuidelineDTO> result = new ArrayList<ListenGuidelineDTO>();
        Object[] objects = SingletonDaoUtil.getListenGuidelineDaoInstance().findByProperty(property, sortExpression, sortDirection, offset, limit);
        for (ListenGuidelineEntity item : (List<ListenGuidelineEntity>) objects[1]) {
            ListenGuidelineDTO dto = ListenGuidelineBeanUtil.entity2Dto(item);
            result.add(dto);
        }
        objects[1] = result;
        return objects;
    }
}
