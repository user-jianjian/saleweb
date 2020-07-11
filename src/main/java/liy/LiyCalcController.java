package liy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "liycalc")
public class LiyCalcController {

	public String getString() {
		return null;
	}

	public int getInt() {
		return 1;
	}
	
	public float getFloat() {
		
		float f = 1f;
		return f;
	}
	
	@RequestMapping(value = "getMap")
	public Map getMap() {
		Map map = new HashMap();
		map.put("name", "张三");
		map.put("sex", "男");
		map.put("age", "20");
		map.put("address", "工大");
		return map;
	}
	
	
	@RequestMapping(value = "getListMap")
	public List<Map<String,Object>> getListMap() {
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("name", "张三");
		map.put("sex", "男");
		map.put("age", "20");
		map.put("address", "工大");
		list.add(map);
		return list;
	}
	
	
	public class Person{
		private String name;
		private int age;
		private String sex;
		private String address;
	}

}
