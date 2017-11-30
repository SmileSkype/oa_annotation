package cn.edu.action;

import java.util.Collection;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.edu.domain.Menuitem;
import cn.edu.domain.User;
import cn.edu.service.PrivilegeService;
import cn.edu.service.UserService;
import cn.edu.utils.OAUtils;
/**
 * 权限树的action
 */
@Controller("privilegeAction")
@Scope("prototype")
public class PrivilegeAction extends BaseAction<Menuitem> {
	@Resource(name="privilegeService")
	private PrivilegeService privilegeService;
	@Resource(name="userService")
	private UserService userService;
	
	private List<Menuitem> privilegeList;
	public List<Menuitem> getPrivilegeList() {
		return privilegeList;
	}
	//接收页面上通过ajax传输过来的数据
	private Long uid;
	private String mids;
	private Long[] aa;
	private Collection<Menuitem> checkedNodes;
	public Collection<Menuitem> getCheckedNodes() {
		return checkedNodes;
	}
	public void setCheckedNodes(Collection<Menuitem> checkedNodes) {
		this.checkedNodes = checkedNodes;
	}
	public Long[] getAa() {
		return aa;
	}
	public void setAa(Long[] aa) {
		this.aa = aa;
	}
	public Long getUid() {
		return uid;
	}
	public void setUid(Long uid) {
		this.uid = uid;
	}
	public String getMids() {
		return mids;
	}
	public void setMids(String mids) {
		this.mids = mids;
	}
	
	/**
	 * 展示用户和权限树之间的关系
	 */
	public String showPrivilege(){
		this.privilegeList = (List<Menuitem>) privilegeService.getAllMenuitem(this.getUid());
		return SUCCESS;
	}
	
	/**
	 * 保存用户和权限树之间的关系
	 */
	public String savePrivilege(){
		User user = userService.getUserById(this.getUid());
		Set<Menuitem> menuitemList = privilegeService.getMenuitemByPIDS(OAUtils.string2Longs(this.getMids()));
		user.setMenuitems(menuitemList);
		userService.updateUser(user);
		return SUCCESS;
	}
	/**
	 * 根据用户查询出左侧权限树的菜单
	 */
	public String showMenuitemByUser(){
		User user = OAUtils.fromSession();
		//如果用户为空，说明需要重新登录
		if(user != null){
			this.privilegeList = (List<Menuitem>) privilegeService.showMenuitemByUser(user);
			return SUCCESS;
		}
		return "login";
	}
	/**
	 * 测试从前台页面传递过来的复杂类型数据
	 * @return
	 */
	public String aaa(){
		System.out.println(this.aa);
		return SUCCESS;
	}
	
}
