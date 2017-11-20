package cn.edu.action;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 封装一些共用的内容
 */
public class BaseAction<T> extends ActionSupport implements ModelDriven<T>{
//	public class BaseAction extends ActionSupport{ 重构前
	private Class clazz;
	private T t;
	public BaseAction(){
		try {
			ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
			this.clazz = (Class) type.getActualTypeArguments()[0];
			this.t = (T) clazz.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static final String LISTACTION = "listAction";
	public static final String ADDUI = "addUI";
	public static final String UPDATEUI = "updateUI";
	public static final String ACTION2ACTION = "action2action";
	public String listAction = LISTACTION;
	public String addUI = ADDUI;
	public String updateUI = UPDATEUI;
	public String action2action = ACTION2ACTION;
	public T getModel() {
		return t;
	}

}
