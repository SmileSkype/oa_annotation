package cn.edu.dao.base;

import java.io.Serializable;
import java.lang.reflect.MalformedParameterizedTypeException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.orm.hibernate5.HibernateTemplate;

public class BaseDaoImpl<T> implements BaseDao<T> {
	
	private Class clazz;
	/**
	 * 1、在父类中执行一段代码，这个代码的执行时间为子类创建对象的时候，这段代码已经执行了，根据这个需求，两种方案
	 * 		利用static 静态代码块
	 * 		利用父类的构造函数
	 * 2、分析
	 * 		因为得到ParameterizedType需要用到this关键字，而this关键不能出现在static语句块中，所以只能选择父类的构造器
	 */
	public BaseDaoImpl(){
		/**
		 * ParameterizedType就是泛型
		 */
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		this.clazz = (Class) type.getActualTypeArguments()[0];
		System.out.println(type.getRawType());
	}
	//注入hibernateTemplate
	@Resource(name="hibernateTemplate")
	public HibernateTemplate hibernateTemplate;
	

	public Collection<T> getAllEntry() {
		return (Collection<T>) hibernateTemplate.find("from "+this.clazz.getName());
	}

	public T getEntryById(Serializable id) {
		return (T) hibernateTemplate.get(clazz, id);
	}

	public void saveEntry(T t) {
		hibernateTemplate.save(t);
	}

	public void updateEntry(T t) {
		hibernateTemplate.update(t);
	}

	public void deleteEntryById(Serializable id) {
		T t = (T) hibernateTemplate.get(clazz, id);
		this.hibernateTemplate.delete(t);
	}

}
