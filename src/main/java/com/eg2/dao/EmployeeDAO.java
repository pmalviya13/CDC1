package com.eg2.dao;

import java.sql.*;
import com.eg2.properties.MYSQLConnection;
import com.eg2.kafka.*;
import java.util.*;
import com.eg2.dto.*;

public class EmployeeDAO {
	private static int lastCode=-1;
    public static void getEmployees()
    {
    	PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		EmployeeDTO employee=null;
		List<EmployeeDTO> employees=new ArrayList<>();
		try
		{	
			Connection connection=MYSQLConnection.getConnection();
			int i=0;
			boolean b=true;
			while(b)
			{
				System.out.println("\tLastCode: "+lastCode);
				preparedStatement=connection.prepareStatement("select * from employee where code >?");
				preparedStatement.setInt(1,lastCode);
				resultSet=preparedStatement.executeQuery();	
				while(resultSet.next())
				{
					employee=new EmployeeDTO();
					employee.setCode(resultSet.getInt("code"));
					employee.setName(resultSet.getString("name").trim());
					employee.setDepartmentCode(resultSet.getInt("department_code"));
					employee.setDesignationCode(resultSet.getInt("designation_code"));
					employees.add(employee);
					lastCode=employee.getCode();

				}
				KProducer.sendRecords(employees);
				for(EmployeeDTO e:employees)
				{
					System.out.println("Code: "+e.getCode()+" Name: "+e.getName());
				}	
				employees.clear();
				Thread.sleep(2000);
				i++;
			}
			resultSet.close();
			preparedStatement.close();
			connection.close();
		}catch(Exception e)
		{
			System.out.println("Exception EmployeeDAO: "+e.getMessage());
		}   
    }
}
