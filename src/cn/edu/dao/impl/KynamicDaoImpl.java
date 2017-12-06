package cn.edu.dao.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Repository;

import cn.edu.dao.KynamicDao;
import cn.edu.dao.base.BaseDaoImpl;
import cn.edu.domain.Kynamic;
import cn.edu.domain.Version;
@Repository("kynamicDao")
public class KynamicDaoImpl extends BaseDaoImpl<Kynamic> implements KynamicDao<Kynamic>{
	
	/**
	 * 判断是否存在重名，如果不存在，list长度为0
	 */
	public Boolean isExistName(String name) {
		// TODO Auto-generated method stub
		List<Kynamic> kynamicList = (List<Kynamic>) this.hibernateTemplate.find("from Kynamic where name = ?", name);
		if(kynamicList.size() == 0){  
			return false;
		}else{
			return true;
		}
	}
	
	/*
	 * 判断是否有兄弟节点
	 */
	public Collection<Kynamic> getSiblingNodes(Long kid) {
		// TODO Auto-generated method stub
		/**
		 * select *
			from Kynamic
			where pid = (
						select pid from Kynamic where kid = 2)
		 */
		StringBuffer sbf = new StringBuffer();
		sbf.append("from Kynamic");
		sbf.append(" where pid = (");
		sbf.append("select pid from Kynamic where kid = ? )");
		List<Kynamic> kynamicList = (List<Kynamic>) this.hibernateTemplate.find(sbf.toString(), kid);
		return kynamicList;
	}
	
	/**
	 * 获取当前节点的父节点对象
	 */
	public Kynamic getParentNode(Long kid) {
		// TODO Auto-generated method stub
		/**
		 * select *
			from Kynamic 
			where kid = (select pid 
						from Kynamic 
						where kid = 2)
		 */
		StringBuffer sbf = new StringBuffer();
		sbf.append("from Kynamic ");
		sbf.append("where kid = (");
		sbf.append("select pid from Kynamic where kid = ? )");
		List<Kynamic> kynamicList = (List<Kynamic>) this.hibernateTemplate.find(sbf.toString(), kid);
		return kynamicList.get(0);
	}
	
	public Collection<Version> getVersionByKid(Long kid) {
		List<Version> versionList = (List<Version>) this.hibernateTemplate.find("from Version v where v.kynamic.kid = ?", kid);
		return versionList;
	}

}
