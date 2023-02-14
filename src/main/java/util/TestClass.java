package util;

import java.io.File;
//import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class TestClass {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String userDir=System.getProperty("user.dir");
		System.out.println(userDir);
		String filePath=userDir+"\\src\\main\\java\\config\\config_SIT.properties";
		System.out.println(filePath);
		File file=new File(filePath);
		FileReader filereader=new FileReader(file);
		Properties prop=new Properties();
		prop.load(filereader);
		System.out.println(prop.getProperty("url"));
		System.out.println(prop.getProperty("username"));
		System.out.println(prop.getProperty("password"));
		System.out.println(prop.getProperty("browser"));
	}

}
