package cn.edu.action;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.edu.domain.Menuitem;
import cn.edu.service.MenuitemService;
@Controller("menuitemAction")
@Scope("prototype")
public class MenuitemAction extends BaseAction<Menuitem>{
	
	@Resource(name="menuitemService")
	private MenuitemService menuitemService;
	
	private Collection<Menuitem> menuitemList;
	public Collection<Menuitem> getMenuitemList() {
		return menuitemList;
	}
	
	/**
	 * 一次性加载树
	 */
	public String getAllMenuitem(){
		this.menuitemList = menuitemService.getAllMenuitem();
		return SUCCESS;
	}
	
	/**
	 * 点击事件加载树
	 */
	public String getMenuitemByParentId(){
		this.menuitemList = menuitemService.getMenuitemByParentId(this.getModel().getPid());
		return SUCCESS;
	}
}
