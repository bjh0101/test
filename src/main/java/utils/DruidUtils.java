package utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

public class DruidUtils {
	static Properties properties = null;
	
	//加载Properties文件
	static {
		properties = new Properties();
		
		try {
			InputStream inputStream = DruidUtils.class.getClassLoader().getResourceAsStream("mybatis/db.properties");
			properties.load(inputStream);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//可以获取dataSource
	public static DataSource getDataSource() {
		DataSource dataSource = null;
		try {
			dataSource = DruidDataSourceFactory.createDataSource(properties);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dataSource;
	}
	
	//可以获取数据库连接对象
	public static Connection getConnection() {
		Connection connection = null;
		try {
			connection = getDataSource().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	
	public static void main(String[] args) {
		System.out.println(DruidUtils.getConnection());
	}
}
