package cn.edu.dao;

import java.util.Collection;

import cn.edu.dao.base.BaseDao;
import cn.edu.domain.Kynamic;
import cn.edu.domain.Version;

public interface KynamicDao<T> extends BaseDao<T> {

	public Boolean isExistName(String name);
	
	public Collection<Kynamic> getSiblingNodes(Long kid);

	public Kynamic getParentNode(Long kid);
	
	public Collection<Version> getVersionByKid(Long kid);
}
