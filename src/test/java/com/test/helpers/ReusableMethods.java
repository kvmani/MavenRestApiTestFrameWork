package com.test.helpers;

import java.util.concurrent.TimeUnit;

import com.test.models.AddUserPOJO;
import com.test.models.UserPOJO;
import com.test.utils.GetPropertiesFromExcel;

import io.restassured.response.Response;

public class ReusableMethods {
	public static AddUserPOJO user;
	public static UserPOJO userFromServer;
	public static AddUserPOJO getUserDataToADD() {
		user=new AddUserPOJO();
		user.setemployee_name(GetPropertiesFromExcel.getValueBasedOnKey("employee_name"));
		user.setemployee_salary(GetPropertiesFromExcel.getValueBasedOnKey("employee_salary"));
		user.setemployee_age(GetPropertiesFromExcel.getValueBasedOnKey("employee_age"));
		//user.setPincode(GetPropertiesFromExcel.getValueBasedOnKey("PinCode"));
		return user;
		
	}
	public static UserPOJO getUserDataT0DELETE(String id,String userid) {
		
		userFromServer=new UserPOJO();
		userFromServer.setid(id);
		userFromServer.setUserid(userid);
		return userFromServer;
		
	}
	public int getStatusCode(Response response) {
		return response.getStatusCode();
	}
	public String getContentType(Response response) {
		return response.getContentType();
	}
	public long getresponseTimeIn(Response response,TimeUnit unit) {
		
		return response.getTimeIn(unit);
	}
public static void  verifyStatusCodeis(Response response,int expectedStatusCode) {
		
		response.then().statusCode(expectedStatusCode);
	}
	
public static void main(String[] args) {
		
	user=getUserDataToADD();
	System.out.println("output from user is :"+user);
		//getBaseURL();
		
		
	}
public static String getJsonPathData(Response response, String status) {
	 status= response.jsonPath().getString("status");
	
	return status;
}
}
