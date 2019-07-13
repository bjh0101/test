package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class InfoUtils {
	static Properties properties = null;
	static {
		 properties = new Properties();
		InputStream inputStream = InfoUtils.class.getClassLoader().getResourceAsStream("info.properties");
		try {
			properties.load(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static String getParameter(String name) {
		return properties.getProperty(name);
	}
}
