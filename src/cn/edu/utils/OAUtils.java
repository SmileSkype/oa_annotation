package cn.edu.utils;

import org.apache.struts2.ServletActionContext;

import cn.edu.domain.User;

public class OAUtils {
	/**
	 * 将字符串1,2,3变成Long类型的数组
	 */
	public static Long[] string2Longs(String str){
		String[] s = str.split(",");
		Long[] ids = new Long[s.length];
		int index = 0;
		for(int i=0;i<s.length;i++){
			ids[index] = Long.valueOf(s[i]);
			index ++;
		}
		return ids;
	}
	
	/**
	 * 从session中取出user对象
	 */
	public static User fromSession(){
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
		return user;
	}
	/**
	 * 将用户信息放入session
	 */
	public static void putUser2Session(User user){
		ServletActionContext.getRequest().getSession().setAttribute("user", user);
	}
}
