package com.test.constats;
import com.test.helpers.UserServiceHelper;
public class EndPoints {
	static String baseUrl = UserServiceHelper.getBaseURL();
	public static final String LOGIN=baseUrl+"/login";
	public static final String No_Of_DataRecords=baseUrl+"/employees";
	public static final String GET_DATA=baseUrl+"/employee";
	public static final String ADD_DATA=baseUrl+"/create";
	public static final String UPDATE_DATA=baseUrl+"/update_data";
	public static final String DELETE_DATA=baseUrl+"/delete";

}
