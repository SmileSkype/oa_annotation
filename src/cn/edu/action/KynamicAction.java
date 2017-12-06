package cn.edu.action;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import javax.annotation.Resource;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.edu.domain.Kynamic;
import cn.edu.domain.Version;
import cn.edu.service.KynamicService;
@Controller("kynamicAction")
@Scope("prototype")
public class KynamicAction extends BaseAction<Kynamic> {
	
	@Resource(name="kynamicService")
	private KynamicService kynamicService;
	private Collection<Kynamic> kynamicList;
	private Long kid;
	private String message;
	private Kynamic kynamic;
	
	private Collection<Version> versionList;
	
	
	
	public Collection<Version> getVersionList() {
		return versionList;
	}
	public Kynamic getKynamic() {
		return kynamic;
	}
	public String getMessage() {
		return message;
	}
	public Long getKid() {
		return kid;
	}
	public Collection<Kynamic> getKynamicList() {
		return kynamicList;
	}
	
	/**
	 * 获取所有的Kynamic
	 */
	public String showKynamicTree(){
		this.kynamicList = kynamicService.showAllKynamic();
		return SUCCESS;
	}
	
	/**
	 * 保存，增加节点
	 * @throws Exception 
	 * @throws IllegalAccessException 
	 */
	public String saveKynamic() throws Exception{
		Kynamic kynamic = new Kynamic();
		BeanUtils.copyProperties(kynamic, this.getModel());
		kynamicService.saveKynamic(kynamic);
		this.kid = kynamic.getKid();
		this.message = "操作成功";
		return SUCCESS;
	}
	/**
	 * 判断文件夹的名字是否已经存在
	 */
	public String isExistName(){
		if(this.getModel().getName().trim().isEmpty()){
			this.message = "输入的文件夹的名字不能为空";
			return SUCCESS;
		}
		Boolean flag = kynamicService.isExistName(this.getModel().getName().trim());
		if(flag){
			this.message = "1";  //文件夹的名字已经存在
		}else{
			this.message = "2";  //文件夹的名字可以使用
		}
		return SUCCESS;
	}
	
	/**
	 * 判断当前节点是否有兄弟节点
	 */
	public String showSiblingNodes(){
		this.kynamicList = kynamicService.getSiblingNodes(this.getModel().getKid());
		return SUCCESS;
	}
	
	/**
	 * 获取当前节点的父节点对象
	 */
	public String showParentNode(){
		this.kynamic = kynamicService.getParentNode(this.getModel().getKid());
		return SUCCESS;
	}
	/**
	 * 删除当前节点
	 */
	public String deleteNode(){
		kynamicService.deleteNode(this.getModel().getKid());
		this.message = "操作成功";
		return SUCCESS;
	}
	
	/**
	 * 更新节点的名称
	 */
	public String updateKynamic(){
		Kynamic kynamic = kynamicService.getKynamicById(this.getModel().getKid());
		kynamic.setName(this.getModel().getName());
		kynamicService.saveKynamic(kynamic);
		return SUCCESS;
	}
	
	/**
	 * 根据kynamic节点的kid查询version数据
	 */
	public String showVersionByKid(){
		this.versionList = kynamicService.getVersionByKid(this.getModel().getKid());
		return SUCCESS;
	}
}