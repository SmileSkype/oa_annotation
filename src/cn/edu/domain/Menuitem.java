package cn.edu.domain;

import java.io.Serializable;
import java.util.Set;

public class Menuitem implements Serializable {
	private Long mid;
	private Long pid; //父节点ID
	private String name; //节点上的名字
	private Boolean isParent; //是否为父节点
	private String icon;  //图标图片地址
	private Set<User> users;
	
	public Long getMid() {
		return mid;
	}
	public void setMid(Long mid) {
		this.mid = mid;
	}
	public Long getPid() {
		return pid;
	}
	public void setPid(Long pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Boolean getIsParent() {
		return isParent;
	}
	public void setIsParent(Boolean isParent) {
		this.isParent = isParent;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
}