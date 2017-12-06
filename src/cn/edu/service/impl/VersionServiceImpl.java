package cn.edu.service.impl;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.edu.dao.VersionDao;
import cn.edu.domain.Version;
import cn.edu.service.VersionService;
@Service("versionService")
public class VersionServiceImpl implements VersionService {
	
	@Resource(name="versionDao")
	private VersionDao versionDao;
	
	
	//写在了kynamicServiceImpl中
//	public Collection<Version> getVersionByKid(Long kid) {
//		// TODO Auto-generated method stub
//		return versionDao.getVersionByKid(kid);
//	}

}
