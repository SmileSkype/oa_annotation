package cn.edu.result;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.Result;

public class AjaxResult implements Result{

	public void execute(ActionInvocation invocation) throws Exception {
		 HttpServletResponse response = ServletActionContext.getResponse();
		 response.setCharacterEncoding("utf-8"); //解决编码问题
		 String message = ActionContext.getContext().getValueStack().peek().toString(); //获取栈顶元素
		 response.getWriter().print(message);
	}

}
