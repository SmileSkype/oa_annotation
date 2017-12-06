package cn.edu.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.edu.domain.Version;
import cn.edu.service.VersionService;
@Controller("versionAction")
@Scope("prototype")
public class VersionAction extends BaseAction<Version> {
	
	@Resource(name="versionService")
	private VersionService versionService;
	
	
}
