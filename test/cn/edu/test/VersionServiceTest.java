package cn.edu.test;

import java.util.Collection;

import org.junit.Test;

import cn.edu.domain.Version;
import cn.edu.service.VersionService;

public class VersionServiceTest extends BaseSpring{
	
	@Test
	public void testVersionService(){
		//一开始单独写，后来写在了KynamicService中
//		VersionService versionService = (VersionService) applicationContext.getBean("versionService");
//		Collection<Version> list = versionService.getVersionByKid(1L);
	}
}
