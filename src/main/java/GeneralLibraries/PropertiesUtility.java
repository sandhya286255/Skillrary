package GeneralLibraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This class contains all reusable methods to perform actions on properties file 
 * @author sreek
 *
 */
public class PropertiesUtility {
	
	private Properties property;
	/**
	 * This method is used to initialize properties file
	 * @param filepath
	 */
		
	public void propertiesInit(String filepath) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(filepath);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	
	 property = new Properties();
	try {
		property.load(fis);
	}catch(IOException e) {
		e.printStackTrace();
	}
}
	
	
	
	
	
	/**
	 * This method is used to fetch data from properties file
	 * @param key
	 * @return
	 */
public String readData(String key) {
	return property.getProperty(key);
}






/**
 * This method is used to write and save the data to properties file
 * @param key
 * @param value
 * @param filepath
 * @throws IOException
 */
public void writeData(String key, String value, String filepath) throws IOException {
	property.put(key, value);
	
FileOutputStream fos=null;

try {
	fos = new FileOutputStream(filepath);
}catch(FileNotFoundException e) {
	e.printStackTrace();
}

try {
	property.store(fos, "uodated");
}catch(IOException e) {
	e.printStackTrace();
}
}

}









