package cn.edu.action;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import cn.edu.domain.Department;
import cn.edu.domain.Post;
import cn.edu.domain.User;
import cn.edu.service.DepartmentService;
import cn.edu.service.PostService;
import cn.edu.service.UserService;
@Controller("userAction")
@Scope("prototype")
public class UserAction extends BaseAction<User> {
	
	@Resource(name="userService")
	public UserService userService;
	
	@Resource(name="departmentService")
	public DepartmentService departmentService;
	
	@Resource(name="postService")
	public PostService postService;

	/**
	 * 采用属性注入的方式，而不是VO的方式 
	 */
	private Long did;
	private Long[] pids;
	public Long getDid() {
		return did;
	}
	public void setDid(Long did) {
		this.did = did;
	}
	public Long[] getPids() {
		return pids;
	}
	public void setPids(Long[] pids) {
		this.pids = pids;
	}
	/**
	 * 获取所有用户，显示到也页面中
	 */
	public String getAllUser() throws Exception {
		Collection<User> userList = userService.getAllUser();
		ActionContext.getContext().put("userList", userList);
		return listAction;
	}
	/**
	 * 跳转到添加用户页面
	 * 分析用户页面，得知，需要部门列表和岗位列表
	 */
	public String addUI() throws Exception {
		Collection<Department> departmentList = departmentService.getAllDepartment();
		Collection<Post> postList = postService.getAllPost();
		ActionContext context = ActionContext.getContext();
		context.put("departmentList", departmentList);
		context.put("postList", postList);
		return addUI;
	}
	/**
	 * 添加用户
	 */
	public String add() throws Exception {
		/**
		 * 新建User对象，属性赋值
		 * 通过did，查找部门对象，注入User对象
		 * 通过pids,查找岗位对象，注入User对象
		 * 保存用户对象
		 */
		User user = new User();
		BeanUtils.copyProperties(user, this.getModel());
		//通过did获取部门对象
		Department department = departmentService.getDepartmentById(did);
		//遍历pids,获取岗位对象的集合
		Set<Post> posts = new HashSet<Post>();
		for(Long pid:pids){
			Post post = postService.getPostById(pid);
			posts.add(post);
		}
		user.setDepartment(department);
		user.setPosts(posts);
		//保存用户对象
		userService.saveUser(user);
		return action2action;
	}
	/**
	 * 删除用户
	 */
	public String delete() throws Exception {
		userService.deleteUserById(this.getModel().getUid());
		return action2action;
	}
	/**
	 * 修改用户信息
	 * 如果是页面跳转到action，在action中有一个数组，struts2的拦截器可以自动赋值
	 * 但是如果是回显数据，必须在程序中创建数组的对象
	 */
	public String updateUI() throws Exception {
		/**
		 * 1,值的回显
		 * 		用户的一般属性回显
		 * 		部门的回显
		 * 		岗位的回显
		 * 2,把部门的数据全部提取出来
		 * 3,把岗位的数据全部提取出来
		 */
		//把用户放入对象栈中
		User user = userService.getUserById(this.getModel().getUid());
//		ActionContext.getContext().getValueStack().push(user);
		ActionContext.getContext().put("user",user);
		
		this.did = user.getDepartment().getDid();
		Set<Post> posts = user.getPosts();
		int index = 0;
		this.pids = new Long[posts.size()];
		for (Post post : posts) {
			this.pids[index] = post.getPid();
			index ++;
		}
		//把部门表和岗位表的数据提取出来
		Collection<Department> departmentList = departmentService.getAllDepartment();
		Collection<Post> postList = postService.getAllPost();
		ActionContext context = ActionContext.getContext();
		context.put("departmentList", departmentList);
		context.put("postList", postList);
		return updateUI;
	} 
	/**
	 * 更改用户信息
	 */
	public String update() throws Exception {
		User user = userService.getUserById(this.getModel().getUid());
		BeanUtils.copyProperties(user, this.getModel());
		Department department = departmentService.getDepartmentById(did);
		Set<Post> posts = new HashSet<Post>();
		for (Long pid : pids) {
			Post post = postService.getPostById(pid);
			posts.add(post);
		}
		user.setDepartment(department);
		user.setPosts(posts);
		userService.saveUser(user);
		return action2action;
	}
	/**
	 * 测试使用
	 */
	public String aa() throws Exception {
		System.out.println("censhi");
		return "city";
	}
}
