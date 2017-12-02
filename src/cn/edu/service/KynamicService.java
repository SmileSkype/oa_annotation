package cn.edu.service;

import java.util.Collection;

import cn.edu.domain.Kynamic;

public interface KynamicService {
	public void saveKynamic(Kynamic kynamic);
	
	public Collection<Kynamic> showAllKynamic();

	public Boolean isExistName(String name);
	
	public Collection<Kynamic> getSiblingNodes(Long kid);
	
	public Kynamic getParentNode(Long kid);

	public void deleteNode(Long kid);

	public Kynamic getKynamicById(Long kid);
}
