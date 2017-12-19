package com.bi.explorer.model.dao.account;


import com.bi.explorer.model.entity.Account;
import com.bi.explorer.model.entity.Authority;
import com.bi.explorer.model.entity.NavigateItemEntity;
import com.speed.frame.model.dao.AbstractReadWriteDao;

import java.util.List;


public interface AccountDao  extends AbstractReadWriteDao<Account> {

	Account getAccount(String usrName, String psw);

    Account getAccount(String usrName);

}
