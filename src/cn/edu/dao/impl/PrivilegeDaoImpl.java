package cn.edu.dao.impl;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import cn.edu.dao.PrivilegeDao;
import cn.edu.dao.UserDao;
import cn.edu.dao.base.BaseDaoImpl;
import cn.edu.domain.Menuitem;
import cn.edu.domain.User;
@Repository("privilegeDao")
public class PrivilegeDaoImpl extends BaseDaoImpl<Menuitem> implements PrivilegeDao<Menuitem> {

	@Resource
	private UserDao userDao;
	/**
	 * 根据用户id，来回显自己的权限
	 */
	public Collection<Menuitem> getAllMenuitem(Long uid) {
		/*
		 * 如果是admin,则把所有的checked设置为true
		 * 如果是普通用户，先遍历所有的菜单项，在遍历用户下面的菜单项，然后把所有的菜单项中用户能够访问到的checked设置为true
		 * 当User被提取出来之后，session已经关闭了 
		 */
		User user = (User) userDao.getEntryById(uid);
		Collection<Menuitem> menuitemList = this.getAllEntry();
		Collection<Menuitem> menuitems = (Collection<Menuitem>) this.hibernateTemplate.find("from Menuitem m left join fetch m.users u where u.uid = ?",uid);
		if("admin".equals(user.getUsername())){
			for(Menuitem menuitem:menuitemList){
				menuitem.setChecked(true);
			}
		}else{
			for(Menuitem menuitem:menuitemList){
				for(Menuitem meu : menuitems){
					if(menuitem.getMid().longValue() == meu.getMid().longValue()){
						menuitem.setChecked(true);
					}
				}
			}
		}
		return menuitemList;
	}
	
	/**
	 * 根据自己在页面中勾选的id,来查询对应的对象
	 */
	public Set<Menuitem> getMenuitemByIDS(Long[] ids) {
		StringBuffer sb = new StringBuffer();
		sb.append("from Menuitem where mid in (");
		for(int i=0;i<ids.length;i++){
			if(i<ids.length-1){
				sb.append(ids[i]+",");
			}else{
				sb.append(ids[i]);
			}
		}
		sb.append(")");
		List<Menuitem> menuitemList = (List<Menuitem>) this.hibernateTemplate.find(sb.toString());
		return new HashSet<Menuitem>(menuitemList);
	}
	/**
	 * 根据用户获取权限树的左侧菜单
	 */
	public Collection<Menuitem> showMenuitemByUser(User user){
		if("admin".equals(user.getUsername())){
			return this.getAllEntry();
		}
		/**
		 * 是否可以改为 from User u inner join fetch u.menuList m where u.uid = ?
		 */
		return (Collection<Menuitem>) this.hibernateTemplate.find("from Menuitem m inner join fetch m.users u where u.uid = ?", user.getUid());
	}
	
}