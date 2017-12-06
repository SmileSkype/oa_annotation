package cn.edu.dao;

import java.util.Collection;

import cn.edu.dao.base.BaseDao;
import cn.edu.domain.Version;

public interface VersionDao<T> extends BaseDao<T>{
	
	//写在了KynamicDao中
//	public Collection<Version> getVersionByKid(Long kid);
}
