package cn.edu.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 用于页面跳转的action
 */
@Controller("homeAction")
@Scope("prototype")
public class HomeAction extends ActionSupport{
	
	public String top(){
		return "top";
	}
	
	public String left(){
		return "left";
	}
	
	public String right(){
		return "right";
	}
	
	public String bottom(){
		return "bottom";
	}
}
