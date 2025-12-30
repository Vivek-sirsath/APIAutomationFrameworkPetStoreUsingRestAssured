package api.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserModuleRequests;
import api.payload.UserPOJO;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class UserModuleTestClassUsingDD {
	
	public static Logger logger;

	@Test(priority = 1, dataProvider = "AllData", dataProviderClass = DataProviders.class, enabled = true)
	public void testCreateUser(String userID, String username, String fname, String lname, String email, String pwd, String phone) {

		UserPOJO userPayload = new UserPOJO();
		
		userPayload.setId(Integer.parseInt(userID));
		/*
		 * userPayload.setId(Integer.parseInt(userID));
		 * 
		 * This line fails the test and throws NumberFormatException
		 * FAILED: testCreateUser("", "vivek101", "Vivek", "Shirsath", "vivek@gmail.com", "vS123", "123-456-7890")
           	java.lang.NumberFormatException: For input string: ""
		 * 
		 * Because We've imported the userID from excel sheet directly. We should generate it dynamically.
		 * userPayload.setId((int) (Math.random() * 100000)); // ✅ FIX
		 * 
		 * Why tests failed:
		 * userID = "" from Excel
		 * Integer.parseInt("") → NumberFormatException
		 * 
		 * Best fix:
		 * Generate ID dynamically
		 * Don’t read ID from Excel
		 * 
		 */
//		userPayload.setId((int) (Math.random() * 100000));
		
		userPayload.setUsername(username);
		userPayload.setFirstName(fname);
		userPayload.setLastName(lname);
		userPayload.setEmail(email);
		userPayload.setPassword(pwd);
		userPayload.setPhone(phone);
/*		
		 Create / obtain logger and pass the name of the logger.
		 Whatever the name we want to be print in 'myLog.log' file,
		 We can use that name here.
		 But it should also be present in 'log4j2.properties' file.
		 [logger.file.name=SwaggerPetStoreAPIFramework]
		  
*/
	    logger = LogManager.getLogger("SwaggerPetStoreAPIFramework");

		Response resp = UserModuleRequests.createUser(userPayload);
		
		System.out.println("====================== Post user data ======================");
		
		// log response
		resp.then().log().all();

		// Validate response code
		Assert.assertEquals(resp.getStatusCode(), 200, "Check for POST ststus code");

		// Safety check
		Assert.assertNotNull(userPayload.getUsername(), "Username is null!");
		
		logger.info("POST request of USER module performed successfully using EXCEL data.");

	}
	
	@Test(priority = 2, dataProvider = "userNameData", dataProviderClass = DataProviders.class, enabled = true)
	public void testGetUser(String username) {

		Response resp = UserModuleRequests.getUser(username);
		
		System.out.println("====================== Get user data ======================");

		// log response
		resp.then().log().all();

		// Validate response code
		Assert.assertEquals(resp.getStatusCode(), 200, "Check for GET status code");
		
		logger.info("GET request of USER module performed successfully using EXCEL data.");
	}
	
	@Test(priority = 3, dataProvider = "userNameData", dataProviderClass = DataProviders.class, enabled = true)
	public void testPutUser(String username) {

		Response resp = UserModuleRequests.getUser(username);
		
		System.out.println("====================== Put user data ======================");

		// log response
		resp.then().log().all();

		// Validate response code
		Assert.assertEquals(resp.getStatusCode(), 200, "Check for GET status code");
		
		// Fetch the Updated user data.
		
		logger.info("PUT request of USER module performed successfully using EXCEL data.");
	}
	
	@Test(priority = 4, dataProvider = "userNameData", dataProviderClass = DataProviders.class, enabled = true)
	public void testDeleteUser(String username) {

		Response resp = UserModuleRequests.deleteUser(username);
		
		System.out.println("====================== Delete user data ======================");

		// log response
		resp.then().log().all();

		// Validate response code
		Assert.assertEquals(resp.getStatusCode(), 200, "Check for POST status code");
		
		logger.info("DELETE request of USER module performed successfully using EXCEL data.");
	}
}
