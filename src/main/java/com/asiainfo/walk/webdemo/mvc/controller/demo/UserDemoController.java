package com.asiainfo.walk.webdemo.mvc.controller.demo;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.walkframework.base.system.annotation.DataImport;
import org.walkframework.base.system.annotation.ValidXml;
import org.walkframework.base.tools.excel.ExcelParser;
import org.walkframework.data.bean.Pagination;
import org.walkframework.data.util.DatasetList;
import org.walkframework.data.util.IDataset;
import org.walkframework.data.util.InParam;

import com.asiainfo.walk.webdemo.mvc.controller.app.AppController;
import com.asiainfo.walk.webdemo.mvc.entity.TdMUser;
import com.asiainfo.walk.webdemo.mvc.service.demo.UserDemoService;

/**
 * 	用户管理Controller
 *
 */
@RestController
@RequestMapping("/demo/user")
public class UserDemoController extends AppController {

	@Resource(name = "userDemoService")
	private UserDemoService userDemoService;
	
	/**
	 * 	查询用户列表（带分页 ajax）
	 * 
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "queryUserList")
	public Object queryUserList(InParam<String, Object> inParam, Pagination pagination){
		return userDemoService.queryUserList(inParam, pagination);
	}

	/**
	 * 	进入用户管理界面
	 * 
	 * @return
	 */
	@RequestMapping(value = "forwardUserManager")
	public ModelAndView forwardUserManager(InParam<String, Object> inParam) {
		ModelAndView model = new ModelAndView("demo/user/UserManager");
		// 查询用户列表(不带分页)
		model.addObject("userList", userDemoService.queryUserList(inParam));
		return model;
	}

	/**
	 * 	进入用户详情界面
	 * 
	 * @return
	 */
	@RequestMapping(value = "forwardUserView/{userId}")
	public ModelAndView forwardUserView(@PathVariable Long userId){
		
		ModelAndView model = new ModelAndView("demo/user/UserView");
		model.addObject("userInfo", userDemoService.queryUserInfo(userId));
		return model;
	}

	/**
	 * 	进入用户修改界面
	 * 
	 * @return
	 */
	@RequestMapping(value = "forwardUserModify/{userId}")
	public ModelAndView forwardUserModify(@PathVariable Long userId) {
		ModelAndView model = new ModelAndView("demo/user/UserModify");
		model.addObject("userInfo", userDemoService.queryUserInfo(userId));
		return model;
	}

	/**
	 * 	新增用户
	 * 
	 */
	@RequestMapping(value = "createUser")
	@ValidXml("demo/UserValidator.xml")
	public String createUser(TdMUser user, HttpServletRequest request) {
		try {
			user.setFileId(request.getParameter("attachment_fileId"));
			userDemoService.createUser(user);
		} catch (Exception e) {
			return message.error("新增失败:" + e.getMessage(), e);
		}
		return message.success("新增成功！");
	}

	/**
	 * 	导入用户
	 * 	只要有一条校验失败则全部失败
	 */
	@RequestMapping(value = "importUsers")
	@DataImport(fileName = "fileInfo", xml = "demo/SaleUserImport.xml", type = TdMUser.class)
	public String importUsers(InParam<String, Object> inParam) {
		try {
			
//			List<IData<String, Object>> userList = inParam.getFileList("fileInfo");
			List<TdMUser> users = inParam.getFileList("fileInfo");
			userDemoService.doImportUsers(users);
		} catch (Exception e) {
			return message.error("导入失败:" + e.getMessage(), e);
		}
		return message.success("导入成功！");
	}
	
	/**
	 * 	导入用户 
	 * 	校验失败后可自己控制
	 * 
	 * @throws Exception 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "importUsers2")
	public String importUsers2(InParam<String, Object> inParam, MultipartHttpServletRequest mRequest) throws Exception {
		//1、从excel中获取数据
		String xml = "demo/SaleUserImport.xml";
		IDataset dataset = ExcelParser.importExcel(xml, mRequest.getFile("fileInfo").getInputStream(), TdMUser.class)[0];
		if(CollectionUtils.isEmpty(dataset)) {
			return message.success("导入失败：导入文件记录数为空！");
		}
		
		//2、分拣成功与失败记录
		IDataset succset = new DatasetList();
		IDataset errset = new DatasetList();
		for (Object data : dataset) {
			MetaObject dataMeta = SystemMetaObject.forObject(data);
			Boolean importResult = Boolean.parseBoolean(String.valueOf(dataMeta.getValue("_IMPORT_RESULT")));
			if (importResult) {
				succset.add(data);
			} else {
				errset.add(data);
			}
		}
		
		//3、成功记录数导入到数据库
		if(succset.size() > 0) {
			userDemoService.doImportUsers(succset);
		}
		
		//4、失败记录数前台下载
		if (errset.size() > 0) {
			ExcelParser.error(errset, xml);
		}
		
		return message.success("导入成功！");
	}

	/**
	 * 	修改用户
	 * 
	 */
	@RequestMapping(value = "modifyUser")
	@ValidXml("demo/UserValidator.xml")
	public String modifyUser(TdMUser user, HttpServletRequest request) {
		try {
			user.setFileId(request.getParameter("attachment_fileId"));
			userDemoService.modifyUser(user);
		} catch (Exception e) {
			return message.error("修改失败:" + e.getMessage(), e);
		}
		return message.success("修改成功！");
	}

	/**
	 * 	删除用户
	 * 
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "delUser/{userId}")
	public String delUser(@PathVariable Long userId) {
		try {
			userDemoService.delUser(userId);
		} catch (Exception e) {
			return message.error("删除失败:" + e.getMessage(), e);
		}
		return message.success("删除成功！");
	}
}