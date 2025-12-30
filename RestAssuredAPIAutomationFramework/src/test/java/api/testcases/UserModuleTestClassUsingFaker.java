
/*
 - In this class, we're validating the response received by sending the requests.   
  
 */

package api.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserModuleRequests;
import api.payload.UserPOJO;
import io.restassured.response.Response;

public class UserModuleTestClassUsingFaker {
	
	// Create an object of User Class which will accept fake data.
	Faker faker;
	UserPOJO userPayload;
	public static Logger logger;
	
	@BeforeTest
	public void generateTestData() {
		
		    faker = new Faker();
		    userPayload = new UserPOJO();
		    
		    /*  int id;
			  String username;
			  String firstName;
			  String lastName;
			  String email;
			  String password;
			  String phone;
			  int userStatus = 0;
		    */
		    
		    
		    userPayload.setId(faker.idNumber().hashCode());
		    userPayload.setUsername(faker.name().username());
		    userPayload.setFirstName(faker.name().firstName());
		    userPayload.setLastName(faker.name().lastName());
		    userPayload.setEmail(faker.internet().safeEmailAddress());
		    userPayload.setPassword(faker.internet().password(5,10));
		    userPayload.setPhone(faker.phoneNumber().cellPhone());
		    
		    // Create / obtain logger and pass the name of the logger.
		    logger = LogManager.getLogger("SwaggerPetstoreAPIFramework");
		    		
	}
	
	@Test (priority = 1)
	public void testCreateUser() {
		
		Response resp = UserModuleRequests.createUser(userPayload);
		
		// log response
		resp.then().log().all();
		
		// Validate response code
		Assert.assertEquals(resp.getStatusCode(), 200, "Check for POST status code");
		
		// Safety check
		Assert.assertNotNull(userPayload.getUsername(), "Username is null!");
		logger.info("POST request of USER module performed successfully using faker class data.");
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			
		}
		
	}
	
	@Test (priority = 2, dependsOnMethods = "testCreateUser")
	public void testGetUser() {
		
		Response resp = UserModuleRequests.getUser(this.userPayload.getUsername());
		
		System.out.println("============ Get User Data Output ============");
		// log response
		resp.then().log().all();
		
		// Validate response code
		Assert.assertEquals(resp.getStatusCode(), 200, "Check for GET status code");
		
		logger.info("GET request of USER module performed successfully using faker class data.");
	}
	
	@Test (priority = 3, dependsOnMethods = "testGetUser")
	public void testUpdateUser() {
			
	    userPayload.setFirstName(faker.name().firstName());
	    
	    try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			
		}
		Response resp = UserModuleRequests.updateUser(this.userPayload.getUsername(), userPayload);
		
		System.out.println("============ Update User Data Output ============");
		// log response
		resp.then().log().all();
		
		// Validate response code
		Assert.assertEquals(resp.getStatusCode(), 200, "Check for PUT status code");
		
		// Check if the firstname is updated or not
		Response responsePostUpdate = UserModuleRequests.getUser(this.userPayload.getFirstName());
		
		System.out.println("============ Response After Updating User ===========");
		responsePostUpdate.then().log().all();
		
		logger.info("UPDATE request of USER module performed successfully using faker class data.");
	}
	
	@Test (priority = 4, dependsOnMethods = "testUpdateUser")
	public void testDeleteUser() {
		
		Response resp = UserModuleRequests.deleteUser(this.userPayload.getUsername());
		
		System.out.println("============ Delete User Data Output ============");
		// log response
		resp.then().log().all();
		
		// Validate response code
		Assert.assertEquals(resp.getStatusCode(), 200, "Check for DELETE status code");
		
		logger.info("DELETE request of USER module performed successfully using faker class data.");
	}

}
