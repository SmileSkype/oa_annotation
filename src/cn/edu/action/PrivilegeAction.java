package cn.edu.action;

import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.edu.domain.Menuitem;
import cn.edu.service.PrivilegeService;
@Controller("privilegeAction")
@Scope("prototype")
public class PrivilegeAction extends BaseAction<Menuitem> {
	@Resource(name="privilegeService")
	private PrivilegeService privilegeService;
	
	private List<Menuitem> privilegeList;
	public List<Menuitem> getPrivilegeList() {
		return privilegeList;
	}


	public String showPrivilege(){
		this.privilegeList = (List<Menuitem>) privilegeService.getAllMenuitem();
		return SUCCESS;
	}
	
}
