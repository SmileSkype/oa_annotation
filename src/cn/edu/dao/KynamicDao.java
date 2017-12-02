package cn.edu.dao;

import java.util.Collection;

import cn.edu.dao.base.BaseDao;
import cn.edu.domain.Kynamic;

public interface KynamicDao<T> extends BaseDao<T> {

	public Boolean isExistName(String name);
	
	public Collection<Kynamic> getSiblingNodes(Long kid);

	public Kynamic getParentNode(Long kid);
	
	
}
