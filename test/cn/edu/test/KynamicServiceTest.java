package cn.edu.test;

import org.junit.Test;

import cn.edu.domain.Kynamic;
import cn.edu.service.KynamicService;

public class KynamicServiceTest extends BaseSpring{
	@Test
	public void testSaveKynamic(){
		KynamicService kynamicService = (KynamicService) applicationContext.getBean("kynamicService");
		Kynamic kynamic = new Kynamic();
		kynamic.setIsParent(true);
		kynamic.setName("知识管理");
		kynamic.setPid(0L);
		kynamicService.saveKynamic(kynamic);
	}
}
