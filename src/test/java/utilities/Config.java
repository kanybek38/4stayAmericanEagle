package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {
	private static Properties properties;
	static{
		String property = "src/test/resources/testdata/configuration.properties";
		try {
			FileInputStream inputStream = new FileInputStream(property);
			properties = new Properties();
			properties.load(inputStream);
			inputStream.close();
			
		} catch (IOException e) {
			System.out.println("File not found");
			e.printStackTrace();
		}
	}
	
	public static String getProperty(String key){
		return properties.getProperty(key);
	}

}
