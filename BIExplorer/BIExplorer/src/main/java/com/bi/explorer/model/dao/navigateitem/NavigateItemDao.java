package com.bi.explorer.model.dao.navigateitem;

import com.bi.explorer.model.entity.Account;
import com.bi.explorer.model.entity.NavigateItemEntity;
import com.speed.frame.model.dao.AbstractReadWriteDao;

import java.util.List;


public interface NavigateItemDao extends AbstractReadWriteDao<NavigateItemEntity> {
    NavigateItemEntity getItem(Integer item);

    List<NavigateItemEntity> getItems(Account account);
}
