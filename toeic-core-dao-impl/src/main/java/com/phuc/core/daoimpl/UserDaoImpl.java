package com.phuc.core.daoimpl;

import com.phuc.core.common.utils.HibernateUtil;
import com.phuc.core.dao.UserDao;
import com.phuc.core.data.daoimpl.AbstractDao;
import com.phuc.core.persistence.entity.UserEntity;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class UserDaoImpl extends AbstractDao<Integer, UserEntity> implements UserDao {
    public UserEntity findUserByUserNameAndPassword(String name, String password) {
        UserEntity entity = new UserEntity();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            StringBuilder sql = new StringBuilder("FROM UserEntity WHERE name= :name AND password= :password");
            Query query = session.createQuery(sql.toString());
            query.setParameter("name", name);
            query.setParameter("password", password);
            entity = (UserEntity) query.uniqueResult();
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            throw e;
        } finally {
            session.close();
        }
        return entity;
    }
}
