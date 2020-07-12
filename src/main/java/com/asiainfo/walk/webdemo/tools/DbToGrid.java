package com.asiainfo.walk.webdemo.tools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.walkframework.base.system.common.Common;
import org.walkframework.batis.tools.dbtobean.ConnectionTools;
import org.walkframework.batis.tools.dbtobean.CreateBeanConfig;
import org.walkframework.batis.tools.dbtobean.CreateBeans;
import org.walkframework.data.util.IData;

/**
 * 根据数据库表生成easyui datagrid
 * 
 */
public abstract class DbToGrid {
	
	public static void main(String[] args) throws Exception {

		// 打印表信息
		printFieldInfo("TD_M_USER");
	}
	
	/**
	 * 数据源设置
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

	/**
	 * 打印表信息
	 * 
	 * @param tableName
	 * @throws Exception
	 */
	private static void printFieldInfo(String tableName) throws Exception {
		CreateBeanConfig appConfig = createBeanConfig();
		Connection connection = ConnectionTools.getConnection(appConfig.getDriverClassName(), appConfig.getDburl(), appConfig.getDbusername(), appConfig.getDbpassword());
		tableName = tableName.toUpperCase();
		String sql = "select * from " + tableName + " where 1 = 0";
		PreparedStatement pre = null;
		try {
			Map<String, String> columnsMap = getComments(connection, tableName);
			pre = connection.prepareStatement(sql);
			ResultSetMetaData metaData = pre.executeQuery().getMetaData();
			for (int i = 1; i <= metaData.getColumnCount(); i++) {
				String field = getJavaField(metaData.getColumnName(i).toUpperCase());
				String comment = StringUtils.trim(StringUtils.replaceAll(columnsMap.get(metaData.getColumnName(i).toUpperCase()), "(\r\n|\r|\n|\n\r|\")", ""));
				System.out.println(String.format("<th data-options=\"field:'%s',width:150\">%s</th>", field, comment));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			try {
				ConnectionTools.closeConnection(null, null, connection);
			} catch (SQLException e) {
				throw e;
			}
		}
	}

	private static Map<String, String> getComments(Connection connection, String tableName) throws Exception {
		tableName = tableName.toUpperCase();

		ResultSet rs = null;
		Map<String, String> columnsMap = new HashMap<String, String>();
		try {
			rs = connection.getMetaData().getColumns(null, CreateBeans.getSchema(connection), tableName, "%");
			while (rs.next()) {
				columnsMap.put(rs.getString("COLUMN_NAME"), rs.getString("REMARKS"));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			try {
				ConnectionTools.closeConnection(rs, null, null);
			} catch (SQLException e) {
				throw e;
			}
		}
		return columnsMap;
	}

	private static String getJavaField(String code) {
		try {
			code = code.toLowerCase();
			String[] name = code.split("_");
			String msg = name[0];
			for (int i = 1; i < name.length; i++) {
				msg = msg + name[i].substring(0, 1).toUpperCase() + name[i].substring(1, name[i].length());
			}
			return msg;
		} catch (Exception e) {
			throw new RuntimeException("Create the JavaBeans property name failed, possibly due to the incoming table name error.\r" + e.getMessage());
		}
	}
}
