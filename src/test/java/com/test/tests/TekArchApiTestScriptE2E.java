package com.test.tests;

import java.util.List;

import org.testng.AssertJUnit;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.test.helpers.ReusableMethods;
import com.test.helpers.UserServiceHelper;
import com.test.models.UserPOJO;

import io.restassured.response.Response;
@Listeners(com.test.helpers.Listener.class)
public class TekArchApiTestScriptE2E extends UserServiceHelper {
	@Test
	public void testcase1No_Of_DataRecords() {
		
			
		No_Of_DataRecords();

		}
	@Test
	public void testcase2createEmployee() {
		
		
		addUserData();

	}
	@Test
	public void testcase3deleteEmployee() {
		
		deleteUserData();

	}
	
	@Test
	public void testcase4deleteEmployeeId0() {
		
		
		deleteUserDataId0();

	}
	
	@Test
	public void testcase5getDataofEmployeeId() {
		
		
		getDataOfUserId();

	}
	
		
	}


