package cn.edu.action;

import java.util.Collection;

import javax.annotation.Resource;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import cn.edu.domain.Post;
import cn.edu.service.PostService;
@Controller("postAction")
@Scope("prototype")
public class PostAction extends BaseAction<Post>{
	
	@Resource(name="postService")
	private PostService postService;
	
	/**
	 * 获取所有的岗位
	 */
	public String getAllPosts(){
		Collection<Post> postList = postService.getAllPost();
		ActionContext.getContext().put("postList", postList);
		return listAction;
	}
	
	/**
	 * 增加岗位页面
	 */
	public String addUI() throws Exception {
		return addUI;
	}
	/**
	 * 增加岗位
	 */
	public String add() throws Exception {
		/**
		 * 1,新建Post对象
		 * 2,将model中的属性赋值给Post
		 * 3,将post保存到数据库
		 */
		Post post = new Post();
		BeanUtils.copyProperties(post, this.getModel());
		postService.savePost(post);
		return action2action;
	}
	/**
	 * 进入修改页面
	 */
	public String updateUI() throws Exception {
		/**
		 * 1,获取页面传过来的id，根据id查询数据库中的数据
		 * 2,将数据回显到页面中
		 */
		Post post = postService.getPostById(this.getModel().getPid());
		ActionContext.getContext().getValueStack().push(post);
		return updateUI;
	}
	/**
	 * 保存修改
	 */
	public String update() throws Exception {
		/**
		 * 1,根据pid，查询数据库中的值
		 * 2,进行属性赋值
		 * 3,保存修改
		 */
		Post post = postService.getPostById(this.getModel().getPid());
		BeanUtils.copyProperties(post, this.getModel());
		postService.savePost(post);
		return action2action;
	}
	/**
	 * 根据id删除岗位
	 */
	public String delete() throws Exception {
		postService.deletePostById(this.getModel().getPid());
		return action2action;
	}
}
