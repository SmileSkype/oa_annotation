package cn.edu.service.impl;

import java.io.Serializable;
import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.dao.DepartmentDao;
import cn.edu.domain.Department;
import cn.edu.service.DepartmentService;
@Service(value="departmentService")
public class DepartmentServiceImpl implements DepartmentService {
	
	@Resource(name="departmentDao")
	private DepartmentDao departmentDao;
	
	@Transactional(readOnly=false)
	public void saveDepartment(Department department) {
		departmentDao.saveEntry(department);
	}
	
	@Transactional(readOnly=false)
	public void updateDepartment(Department department) {
		departmentDao.updateEntry(department);
	}
	
	@Transactional(readOnly=false)
	public void deleteDepartmentById(Serializable id, String deleteModel) {
		departmentDao.deleteEntryById(id);
	}

	public Collection<Department> getAllDepartment() {
		return departmentDao.getAllEntry();
	}

	public Department getDepartmentById(Serializable id) {
		return (Department) departmentDao.getEntryById(id);
	}

}
