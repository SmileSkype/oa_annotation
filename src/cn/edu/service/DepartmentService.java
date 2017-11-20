package cn.edu.service;

import java.io.Serializable;
import java.util.Collection;

import org.springframework.transaction.annotation.Transactional;

import cn.edu.domain.Department;

public interface DepartmentService {
	/**
	 * 添加部门
	 * @param department
	 */
	public void saveDepartment(Department department);
	/**
	 * 更新部门信息
	 * @param department
	 */
	public void updateDepartment(Department department);
	/**
	 * 根据部门id,删除部门，这里的id的类型写成Serializable是因为基本数据类型和String类型都实现了Serializable接口
	 * 这里写成父类的形式，达到重用的目的
	 * @param id
	 * @param deleteModel
	 */
	public void deleteDepartmentById(Serializable id,String deleteModel);
	
	/**
	 * 获取所有的部门信息，这里使用Collection作为接收返回的值，也是达到重用的目的，父类
	 * @return
	 */
	public Collection<Department> getAllDepartment();
	
	/**
	 * 通过id，查询部门信息
	 * @param id
	 * @return
	 */
	public Department getDepartmentById(Serializable id);
}
