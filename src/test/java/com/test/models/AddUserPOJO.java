package com.test.models;

public class AddUserPOJO {
	private String id;
	private String employee_name;
	private String employee_salary;
	private String employee_age;
	private String profile_image;
	
	
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
	 public String toString() {
		 return "employee_name:"+employee_name+"\n salary:"+String.valueOf(employee_salary);
	 }
}
