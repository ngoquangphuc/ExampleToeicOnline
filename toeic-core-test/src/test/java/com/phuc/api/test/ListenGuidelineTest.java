package com.phuc.api.test;

import com.phuc.core.dao.ListenGuidelineDao;
import com.phuc.core.daoimpl.ListenGuidelineDaoImpl;
import org.testng.annotations.Test;

public class ListenGuidelineTest {
    @Test
    public void testFindByProperties() {
        ListenGuidelineDao listenGuidelineDao =  new ListenGuidelineDaoImpl();
        Object result = listenGuidelineDao.findByProperty(null, null, null, null, 2, 2);
    }
}
