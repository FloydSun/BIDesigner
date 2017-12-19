package com.bi.explorer.model.dao.navigateitem;


import com.bi.explorer.model.entity.Account;
import com.bi.explorer.model.entity.NavigateItemEntity;
import com.speed.frame.model.dao.AbstractReadWriteDaoImpl;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;


@Repository(NavigateItemDaoImpl.NAME)
@Transactional("transactionManager")
public class NavigateItemDaoImpl extends AbstractReadWriteDaoImpl<NavigateItemEntity> implements NavigateItemDao {
	public final static String NAME = "NavigateItemDaoImpl";

	@PersistenceContext(unitName = "localDB")
	public void setEntityManager(EntityManager entityManager) {
		super.setEntityManager(entityManager);
	}



	@Override
	public NavigateItemEntity getItem(Integer item) {
		Query q = this.getEntityManager().createQuery("from NavigateItemEntity where id = :id");
		q.setParameter("id", item);
		List ret = q.getResultList();
		if (ret.isEmpty()){
			return null;
		}
		return (NavigateItemEntity) ret.get(0);
	}

    @Override
    public List<NavigateItemEntity> getItems(Account account) {
        Query q = this.getEntityManager().createNativeQuery("select distinct navigator_item_id " +
                "from CUX_NAVIGATEAUTHORITY_T where role in :roles");
        q.setParameter("roles", Account.getRoleIds(account));
        List<Integer> navItemIds = q.getResultList();

		if (!navItemIds.isEmpty()) {
			q = this.getEntityManager().createQuery("from NavigateItemEntity where url is null or id in :ids");
			q.setParameter("ids", navItemIds);
			return q.getResultList();
		}

		return new ArrayList<NavigateItemEntity>();

    }
}
