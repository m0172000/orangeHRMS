package commonUtlis;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class CommonDataReader {

	private Properties properties;

	public CommonDataReader() {
		try {
			FileInputStream fis = new FileInputStream("C:\\Users\\Hp\\eclipse-workspace\\OrangeHRMS\\TestData\\commonData.properties");
			properties = new Properties();
			properties.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Failed to load config.properties file.");
		}
	}

	public String getProperty(String key) {
		return properties.getProperty(key);
	}
}
