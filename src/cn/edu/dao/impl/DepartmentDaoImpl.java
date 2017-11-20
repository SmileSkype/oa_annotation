package cn.edu.dao.impl;


import org.springframework.stereotype.Repository;

import cn.edu.dao.DepartmentDao;
import cn.edu.dao.base.BaseDaoImpl;
import cn.edu.domain.Department;

@Repository(value="departmentDao")
public class DepartmentDaoImpl extends BaseDaoImpl<Department> implements DepartmentDao<Department> {

}
