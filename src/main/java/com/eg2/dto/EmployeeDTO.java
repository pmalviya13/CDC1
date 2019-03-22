package com.eg2.dto;

public class EmployeeDTO
{
	private int code;
	private String name;
	private int departmentCode;
	private int designationCode;
	
	public int getDesignationCode()
	{
	        return this.designationCode;
	} 
	public void setDesignationCode(int designationCode)
	{
		this.designationCode = designationCode;
	}
	public int getDepartmentCode()
	{
	        return this.departmentCode;
	} 
	public void setDepartmentCode(int departmentCode)
	{
		this.departmentCode = departmentCode;
	}
	public String getName()
	{
	        return this.name;
	} 
	public void setName(String name)
	{
		this.name = name;
	}
	public int getCode()
	{
	        return this.code;
	} 
	public void setCode(int code)
	{
		this.code = code;
	}
}