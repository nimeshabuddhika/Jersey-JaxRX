package com.jersey.app.ws.dao.impl;

import com.jersey.app.ws.dao.DAO;
import com.jersey.app.ws.dto.UserDTO;
import com.jersey.app.ws.entity.UserEntity;
import com.jersey.app.ws.utils.HibernateU;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.BeanUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * @author Nimesha Buddhika on 7/11/2018
 */
public class MySQLDAO implements DAO {

    Session session;

    @Override
    public void openConnection() {
        SessionFactory sessionFactory = HibernateU.getSessionFactory();
        session = sessionFactory.openSession();
    }

    @Override
    public UserDTO getUserByName(String userName) {
        UserDTO userDto = null;

        CriteriaBuilder cb = session.getCriteriaBuilder();

        //Create Criteria against a particular persistent class
        CriteriaQuery<UserEntity> criteria = cb.createQuery(UserEntity.class);

        //Query roots always reference entitie
        Root<UserEntity> profileRoot = criteria.from(UserEntity.class);
        criteria.select(profileRoot);
        criteria.where(cb.equal(profileRoot.get("email"), userName));

        // Fetch single result
        Query<UserEntity> query = session.createQuery(criteria);
        List<UserEntity> resultList = query.getResultList();
        if (resultList != null && resultList.size() > 0) {
            UserEntity userEntity = resultList.get(0);
            userDto = new UserDTO();
            BeanUtils.copyProperties(userEntity, userDto);
        }
        return userDto;
    }

    @Override
    public void closeConnection() {
        if(session != null)
            session.close();
    }

    @Override
    public UserDTO saveUser(UserDTO user) {
        UserDTO returnValue = null;
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);

        session.beginTransaction();
        session.save(userEntity);
        session.getTransaction().commit();

        returnValue = new UserDTO();
        BeanUtils.copyProperties(userEntity, returnValue);

        return returnValue;
    }
}
