package com.test.models;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.fasterxml.jackson.databind.ObjectMapper;

public class UserPOJO {
	
	private String id;
	private String employee_name;
	private String employee_salary;
	private String employee_age;
	private String profile_image;
	private String Userid;
	
	
	private HashMap<String,Object>additionalProperties=new HashMap<String,Object>();
	public String getid() {
		 return id;
	 }
	public void setid(String eid) {
		 this.id=eid;
	 }
	 public String getemployee_name() {
		 return employee_name;
	 }
	 public void setemployee_name(String employee_nam) {
		 this.employee_name=employee_nam;
	 }
	 public String getemployee_salary() {
		 return employee_salary;
	 }
	 public void setemployee_salary(String employee_sal) {
		 this.employee_salary=employee_sal;
	 }
	 public String getemployee_age() {
		 return employee_age;
	 }
	 public void setemployee_age(String employee_ag) {
		 this.employee_age=employee_ag;
	 }
	 public String getprofile_image() {
		 return profile_image;
	 }
	 public void setprofile_image(String profile_img) {
		 this.profile_image=profile_img;
	 }
	 
	 public String getUserid() {
		 return Userid;
	 }
	 public void setUserid(String Usrid) {
		 this.Userid=Usrid;
	 }
	 
	
	 
	 public void   setUserMap() {
		 additionalProperties.put("id",id);
		 additionalProperties.put("employee_name",employee_name);
		 additionalProperties.put("employee_salary",employee_salary);
		 additionalProperties.put("employee_age",employee_age);
		 additionalProperties.put("profile_image",profile_image);
		 additionalProperties.put("Userid",Userid);
		 
		 
	 }
	
		 
	 }


