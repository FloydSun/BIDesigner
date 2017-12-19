package com.bi.explorer.model.dao.account;


import com.bi.explorer.model.entity.Account;
import com.bi.explorer.model.entity.Authority;
import com.bi.explorer.model.entity.Role;
import com.speed.frame.model.dao.AbstractReadWriteDaoImpl;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;


@Repository(AccountDaoImpl.NAME)
@Transactional("transactionManager")
public class AccountDaoImpl  extends AbstractReadWriteDaoImpl<Account> implements AccountDao {
	public final static String NAME = "AccountDaoImpl";

	@PersistenceContext(unitName = "localDB")
	EntityManager entityManager;

	@Override
	public Account getAccount(String usrName, String psw) {
        Query q = entityManager.createQuery("from Account where name = :usrName and  password = :psw");
        q.setParameter("usrName", usrName);
        q.setParameter("psw", psw);
        List r = q.getResultList();
        if (!r.isEmpty()){
            return (Account) r.get(0);
        }
        return null;
	}

    @Override
    public Account getAccount(String usrName) {
        Query q = entityManager.createQuery("from Account where name = :usrName");
        q.setParameter("usrName", usrName);
        List r = q.getResultList();
        if (!r.isEmpty()){
            return (Account) r.get(0);
        }
        return null;
    }
}
