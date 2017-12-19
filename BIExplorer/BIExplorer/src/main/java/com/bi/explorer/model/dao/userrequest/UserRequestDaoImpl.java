package com.bi.explorer.model.dao.userrequest;


import com.bi.explorer.model.entity.UserRequestEntity;
import com.speed.frame.model.dao.AbstractReadWriteDaoImpl;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Repository(UserRequestDaoImpl.NAME)
@Transactional("transactionManager")
public class UserRequestDaoImpl extends AbstractReadWriteDaoImpl<UserRequestEntity> implements UserRequestDao {
	public final static String NAME = "UserRequestDaoImpl";

	@PersistenceContext(unitName = "localDB")
	public void setEntityManager(EntityManager entityManager) {
		super.setEntityManager(entityManager);
	}
}
