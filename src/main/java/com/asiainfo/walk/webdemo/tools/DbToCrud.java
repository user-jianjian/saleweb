package com.asiainfo.walk.webdemo.tools;

import org.walkframework.base.system.common.Common;
import org.walkframework.base.tools.dbtocrud.CrudFactory;
import org.walkframework.batis.tools.dbtobean.CreateBeanConfig;
import org.walkframework.data.util.IData;

/**
 * 	根据数据库表生成增删改查代码及实体类
 * 
 * @author shf675
 *
 */
public abstract class DbToCrud {
	
	/**
	 *   执行main方法生成增删改查代码及实体类代码
	 *   
	 * generate(表名，模块目录(英文)，模块名(英文)，功能名(中文))
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		//根包和输出路径设置
		String basePackage = "com.asiainfo.walk.webdemo";
		String outBasePath = "E:/codegen";
		CrudFactory crudFactory = new CrudFactory(createBeanConfig(), basePackage, outBasePath);
		
		//开始生成
		crudFactory.generate("TD_M_STAFF", "staff", "Staff", "工号管理");
		crudFactory.generate("TD_M_USER", "user", "User", "用户管理");
	}

	/**
	 *	 数据源设置
	 * 
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	private static CreateBeanConfig createBeanConfig() {
		IData resource = Common.getInstance().getProperties("boot-ds.xml", "Resource");
		CreateBeanConfig appConfig = new CreateBeanConfig();
		appConfig.setDriverClassName(resource.getString("driverClassName"));
		appConfig.setDburl(resource.getString("jdbcUrl"));
		appConfig.setDbusername(resource.getString("username"));
		appConfig.setDbpassword(resource.getString("password"));
		return appConfig;
	}

}
