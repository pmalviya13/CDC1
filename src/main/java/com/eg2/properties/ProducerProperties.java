package com.eg2.properties;
import java.io.*;
import java.util.Properties;

public class ProducerProperties {
    private static Properties prop=null;
	private static InputStream input;
	
	public static Properties getProperties()
	{
		try
		{	
			prop=new Properties();
			input = ProducerProperties.class.getClassLoader().getResourceAsStream("producerProperties.properties");
			prop.load(input);
			System.out.println("bootstrap-servers: "+prop.getProperty("bootstrap.servers"));
			System.out.println("key.serializer: "+prop.getProperty("key.serializer"));
			System.out.println("value.serializer: "+prop.getProperty("value.serializer"));
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return prop;
	}
}
