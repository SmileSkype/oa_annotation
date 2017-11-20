package cn.edu.action;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import cn.edu.domain.Person;
import cn.edu.service.PersonService;

@Controller("personAction")
public class PersonAction extends ActionSupport{
	@Resource(name="personService")
	private PersonService personService;
	
	public String savePerson(){
		Person person = new Person();
		person.setPname("小赵");
		personService.savePerson(person);
		return null;
	}
	
	public String getPerson(){
		Person person = personService.getPersonById(3L);
		ServletActionContext.getRequest().setAttribute("person", person);
		return "index";
	}
	
	public String aa() throws Exception {
		System.out.println("没有问题啊");
		return null;
	}
}
