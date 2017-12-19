package com.bi.explorer.service.login;

import com.bi.explorer.model.entity.Account;
import com.bi.explorer.model.entity.NavigateItemEntity;
import com.bi.explorer.model.entity.UserRequestEntity;

import java.util.List;

public interface LoginService {

	Account login(String usrName, String psw);

	void logout(Account account, long creationTime, long lastAccessedTime, String ip,
                List<UserRequestEntity> ures);


    List<NavigateItemEntity> getNavigateItems(Account account);

    Account getAccount(String name);

}
