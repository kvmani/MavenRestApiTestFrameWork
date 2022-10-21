package com.test.helpers;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;

import org.hamcrest.Matchers;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.test.constats.EndPoints;
import com.test.models.AddUserPOJO;
import com.test.models.LoginObjectPOJO;
import com.test.models.ResponsePOJO;
import com.test.models.UserPOJO;
import com.test.utils.Utils;
import java.util.List;
import com.test.utils.GenerateReports;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.internal.support.FileReader;
import io.restassured.response.Response;
import io.restassured.response.ResponseBodyExtractionOptions;
import org.json.simple.JSONObject;

import java.io.*;
import java.util.*;
import org.json.simple.*;
import org.json.simple.parser.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UserServiceHelper {
	static Response response;

	public static GenerateReports report = null;

	public static String getBaseURL() {
		report = GenerateReports.getInstance();

		String baseURL = Utils.getApplicationProperty("url");
		System.out.println("url= " + baseURL);
		return baseURL;
	}

	@BeforeTest
	public static void setupBeforeTest() {
		getBaseURL();
		report = GenerateReports.getInstance();
		report.startExtentReport();
		System.out.println("Executig the report iniatiation code!!!");
	}

	@BeforeMethod
	public static void beforeMethod(Method m) {

		System.out.println("Just started the testig of the method" + m.getName());
		report.startSingleTestReport(m.getName());
		report.logTestInfo("before method execution started");

	}

	@AfterMethod
	public static void tearDown(Method m) {
		report.logTestInfo("Finished the test " + m.getName());

	}

	@AfterTest
	public static void tearDownAfterTest() {
		report.logTestInfo("after Test execution is completed");
		report.endReport();

	}

	public static Response addUserData() {
		report.startSingleTestReport("addUserData");
		report.logTestInfo("addUserData: started execution");
		AddUserPOJO user = ReusableMethods.getUserDataToADD();
		response = RestAssured.given().contentType("application/json").body(user).when().post(EndPoints.ADD_DATA);
		report.logTestInfo("getUserData: response code " + response.statusCode());
		System.out.println("the full response is " + response.asPrettyString());
		response.then().body("data.employee_name", Matchers.equalTo("test"));
		response.then().body("data.employee_salary", Matchers.equalTo("123.0"));
		response.then().body("data.employee_age", Matchers.equalTo("23.0"));
		String id = response.jsonPath().getString("data.id");
		System.out.println("added employee id is" + id);
		try {
			FileWriter file = new FileWriter("./createdUserData.json");
			file.write(response.asPrettyString());
			file.close();
		} catch (IOException e) {

			e.printStackTrace();
		}

		return response;
	}

	public static void deleteUserData() {
		report.startSingleTestReport("deleteUserData");
		report.logTestInfo("deleteUserData: started execution");
		Path path = Paths.get("./createdUserData.json");
		JSONParser parser = new JSONParser();
		try {
			String jsonContent = Files.readString(path);
			System.out.println("The json content from file is" + jsonContent);
			try {
				Object obj = parser.parse(jsonContent);
				JSONObject jsonObject = (JSONObject) obj;
				String idToBeDeleted = (String) jsonObject.get("employee_name");
				System.out.println("Found id to be deleted from json file as employee_name:" + idToBeDeleted);
				String deleteEndpoint = EndPoints.DELETE_DATA + "/" + idToBeDeleted;
				System.out.println("the delete endpoint is" + deleteEndpoint);
				response = RestAssured.delete(deleteEndpoint);
				report.logTestInfo("deleteUserData: response code " + response.statusCode());
				System.out.println("the full response is " + response.asPrettyString());
				String id = response.jsonPath().getString("data");
				System.out.println("deleted  employee id is" + id);
			} catch (ParseException e) {

				e.printStackTrace();
			}
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public static void deleteUserDataId0() {
		report.startSingleTestReport("deleteUserDataId0");
		report.logTestInfo("deleteUserDataId0: started execution");
		String deleteEndpoint = EndPoints.DELETE_DATA + "/0";
		response = RestAssured.delete(deleteEndpoint);
		report.logTestInfo("deleteUserData: response code " + response.statusCode());
		System.out.println("the full response is " + response.asPrettyString());
		String id = response.jsonPath().getString("data");

		System.out.println("the  full response is :" + response.asPrettyString());
		System.out.println("the response message is :" + response.jsonPath().getString("message"));
		System.out.println("the response code is :" + response.statusCode());

	}

	public static void getDataOfUserId() {
		report.startSingleTestReport("deleteUserDataId0");
		report.logTestInfo("deleteUserDataId0: started execution");
		String requiredUser = EndPoints.GET_DATA + "/2";
		response = RestAssured.get(requiredUser);
		report.logTestInfo("getDataOfUserId: response code " + response.statusCode());
		System.out.println("the full response is " + response.asPrettyString());

		response.then().body("data.employee_name", Matchers.equalTo("Garrett Winters"));
		response.then().body("data.employee_salary", Matchers.equalTo(170750));
		response.then().body("data.employee_age", Matchers.equalTo(63));
		String id = response.jsonPath().getString("data.id");

	}

	public static void No_Of_DataRecords() {

		response = RestAssured.when().get(EndPoints.No_Of_DataRecords);
		System.out.println("response from server:" + response.asPrettyString());
		System.out.println("status code " + response.statusCode());

		ResponsePOJO responsePojo = response.as(ResponsePOJO.class);

		System.out.println("response from server:" + response.asPrettyString());
		int noofemployees = response.jsonPath().getInt("data.size()");
		response.then().statusCode(200);
		System.out.println("Status from response POJO:" + responsePojo.getStatus());
		System.out.println("no of employee " + noofemployees);

	}

}