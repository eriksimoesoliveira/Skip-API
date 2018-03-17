package br.com.skip.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Properties;

public class DBProperties implements Serializable {
	private static final long serialVersionUID = -1443345445789329102L;

	private static final String PROPERTIES_FILE_URL = "/database.properties";
	
	private static DBProperties instance;
	
	private static Properties prop;
	
	private DBProperties() {
		try {
			prop = new Properties();
			InputStream in = DBProperties.class.getResourceAsStream(PROPERTIES_FILE_URL);
			prop.load(in);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static DBProperties getInstance() {
		
		if (instance == null) {
			instance = new DBProperties();
		}
		
		return instance;
	}
	
	public String getProperty(String propertyName) {
		return prop.getProperty(propertyName);
	}

	
}
