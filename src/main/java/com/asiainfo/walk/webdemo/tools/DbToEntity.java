package com.asiainfo.walk.webdemo.tools;

import org.walkframework.base.system.common.Common;
import org.walkframework.batis.tools.dbtobean.CreateBeanConfig;
import org.walkframework.batis.tools.dbtobean.CreateBeans;
import org.walkframework.data.util.IData;

/**
 * 	根据数据库表生成实体类
 *
 */
public abstract class DbToEntity {
	
	public static void main(String[] args) throws Exception {
		
		//工程根目录设置，此处根据自己的项目位置进行设置
		String outBasePath = "F:\\internship\\saleweb";
		
		//根包和输出路径设置
		String basePackage = "com.asiainfo.walk.webdemo";
		
		
		//开始生成
		String packageName = basePackage + ".mvc.entity";
		String packagePath = outBasePath + "/src/main/java/" + basePackage.replaceAll("\\.", "/") + "/mvc/entity";
		String[][] tables = new String[][]{
//			new String[]{"TD_M_STAFF", packageName, packagePath},
			new String[]{"TF_M_STAFFPASSWD", packageName, packagePath},
		};
		CreateBeans.createJavaBean(tables, createBeanConfig());
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
