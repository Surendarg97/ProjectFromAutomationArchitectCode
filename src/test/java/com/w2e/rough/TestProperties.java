package com.w2e.rough;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {
	
	public static void main(String args[]) throws IOException {
		
		Properties config=new Properties();
		FileInputStream fisConfig=new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//properties//Config.properties");
		config.load(fisConfig);
		System.out.println(config.getProperty("browser"));
		Properties ObjectRespository=new Properties();
		FileInputStream fisObjectRespository=new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//properties//ObjectRespository.properties");
		ObjectRespository.load(fisObjectRespository);
		System.out.println(ObjectRespository.getProperty("bankManagerButton"));
	}

}
