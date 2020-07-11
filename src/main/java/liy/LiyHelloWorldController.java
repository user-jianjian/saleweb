package liy;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "hello")
public class LiyHelloWorldController {

	@RequestMapping(value = "sayHello")
	public String sayHello() {
		return "Hello World";
	}
	
	@RequestMapping(value = "score/yuwen",method = RequestMethod.GET)
	public String queryYuwenScore() {
		
		return "我的语文成绩";
	}
	
	@RequestMapping(value = "score/shuxue",method = RequestMethod.GET)
	public String queryShuxueScore() {
		
		return "我的数学成绩";
	}
	
	@RequestMapping(value = "queryUser/{user}")
	public String queryUser(@PathVariable String user) {
		return "我叫" + user;
	}
	
	@RequestMapping(value = "fetchUser")
	public Map fetchUser() {
		Map user = new HashMap();
		
		user.put("name","张三");
		user.put("age", 20);
		
		return user;
		
	}
	
	@RequestMapping(value = "sayHelloByJsp")
	public String sayHelloByJsp() {
		
		return "liy/HelloWorld";
		
	}


}
