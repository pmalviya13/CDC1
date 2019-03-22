package com.eg2.properties;

import java.sql.*;
import java.util.Properties;
import java.io.*;

public class MYSQLConnection
{
	private static Properties prop=new Properties();
	private static InputStream input=null;
	private static Connection connection=null;
	
	public static Connection getConnection(){
		try
		{
			System.out.println("here");
			input = MYSQLConnection.class.getClassLoader().getResourceAsStream("mysqlConnection.properties");
			prop.load(input);
			System.out.println("database: "+prop.getProperty("database"));
			System.out.println("username: "+prop.getProperty("username"));
			System.out.println("password: "+prop.getProperty("password"));
			Class.forName("com.mysql.jdbc.Driver");
			
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+prop.getProperty("database"),prop.getProperty("username"),prop.getProperty("password"));
		}catch(Exception c)
		{
			System.out.println("Exception MYSQLConnection getConnection: "+c.getMessage());
		
		}
		return connection;
	}
}