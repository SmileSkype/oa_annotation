package cn.edu.service.impl;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.dao.KynamicDao;
import cn.edu.domain.Kynamic;
import cn.edu.service.KynamicService;
@Service("kynamicService")
public class KynamicServiceImpl implements KynamicService {
	
	@Resource(name="kynamicDao")
	private KynamicDao kynamicDao;
	
	/**
	 * 测试保存数据
	 */
	@Transactional(readOnly=false)
	public void saveKynamic(Kynamic kynamic) {
		kynamicDao.saveEntry(kynamic);
	}
	
	/**
	 * 获取所有的kynamic
	 */
	public Collection<Kynamic> showAllKynamic() {
		// TODO Auto-generated method stub
		return kynamicDao.getAllEntry();
	}
	
	/**
	 * 文件名是否已经存在
	 */
	public Boolean isExistName(String name) {
		// TODO Auto-generated method stub
		return kynamicDao.isExistName(name);
	}
	
	/**
	 * 判断当前节点是否有兄弟节点
	 */
	public Collection<Kynamic> getSiblingNodes(Long kid) {
		// TODO Auto-generated method stub
		return kynamicDao.getSiblingNodes(kid);
	}

	/**
	 * 获取当前节点的父节点
	 */
	public Kynamic getParentNode(Long kid) {
		// TODO Auto-generated method stub
		return kynamicDao.getParentNode(kid);
	}
	
	@Transactional(readOnly=false)
	public void deleteNode(Long kid) {
		// TODO Auto-generated method stub
		kynamicDao.deleteEntryById(kid);
	}

	public Kynamic getKynamicById(Long kid) {
		// TODO Auto-generated method stub
		return (Kynamic) kynamicDao.getEntryById(kid);
	}

}
