package cn.edu.domain;

public class Person {
	private Long pid;
	private String pname;
	public Person(Long pid, String pname) {
		super();
		this.pid = pid;
		this.pname = pname;
	}
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getPid() {
		return pid;
	}
	public void setPid(Long pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	
}
