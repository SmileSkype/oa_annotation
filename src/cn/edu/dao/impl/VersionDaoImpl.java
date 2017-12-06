package cn.edu.dao.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Repository;

import cn.edu.dao.VersionDao;
import cn.edu.dao.base.BaseDaoImpl;
import cn.edu.domain.Version;
@Repository("versionDao")
public class VersionDaoImpl extends BaseDaoImpl<Version> implements VersionDao<Version> {
	
	//写在了KynamicDaoImpl中
//	public Collection<Version> getVersionByKid(Long kid) {
//		List<Version> versionList = (List<Version>) this.hibernateTemplate.find("from Version v where v.kynamic.kid = ?", kid);
//		return versionList;
//	}

}
