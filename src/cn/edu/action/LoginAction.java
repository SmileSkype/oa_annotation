package cn.edu.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import cn.edu.domain.User;
import cn.edu.service.LoginService;
import cn.edu.utils.OAUtils;
@Controller("loginAction")
@Scope("prototype")
public class LoginAction extends BaseAction<User>{
	@Resource(name="loginService")
	private LoginService loginService;
	
	public String login(){
		User user = loginService.getUserByUsernameAndPassword(this.getModel().getUsername(), this.getModel().getPassword());
		if(user != null){  //说明登录成功
			OAUtils.putUser2Session(user);
			return "index";
		}else{  //登录失败，跳转到登录页面
			return "login";
		}
	}
}
