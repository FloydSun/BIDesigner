package com.bi.explorer.model.dao.userusage;


import com.bi.explorer.model.entity.UserUsageEntity;
import com.speed.frame.model.dao.AbstractReadWriteDaoImpl;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Repository(UserUsageDaoImpl.NAME)
@Transactional("transactionManager")
public class UserUsageDaoImpl extends AbstractReadWriteDaoImpl<UserUsageEntity> implements UserUsageDao {
	public final static String NAME = "UserUsageDaoImpl";

	@PersistenceContext(unitName = "localDB")
	public void setEntityManager(EntityManager entityManager) {
		super.setEntityManager(entityManager);
	}
}
