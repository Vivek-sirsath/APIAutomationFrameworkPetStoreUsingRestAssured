package api.testcases;

import java.time.LocalDateTime;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.StoreModuleRequests;
import api.payload.OrderPOJO;
import io.restassured.response.Response;

public class StoreModuleTestUsingPropertiesAndFaker {

	// Create an object of OrderPOJO Class which will accept fake data.
	Faker faker;
	OrderPOJO orderPayload;
	public static Logger logger;
	
	@BeforeTest
	public void generateTestData() {
		
		// Initialize Faker class object
		faker = new Faker();
		
		// Initialize OrderPOJO class object
		orderPayload = new OrderPOJO();
		
		// Create local date time
		String shipDate = LocalDateTime.now().toString();
		
		String status = "placed"; // "placed", "approved", "delivered"
		
//		If you want controlled variation, we can use this instead :
//		String[] statusValues = {"placed", "approved", "delivered"};
//		orderPayload.setStatus(statusValues[new Random().nextInt(statusValues.length)]);
		
		
		orderPayload.setId(faker.number().numberBetween(1000, 9999));
		orderPayload.setPetId(faker.number().numberBetween(100, 999));
		orderPayload.setQuantity(faker.number().numberBetween(1, 5));
		orderPayload.setShipDate(shipDate);
		orderPayload.setStatus(status);
		orderPayload.setComplete(true);
		
		// Obtain logger and pass the name of the logger
		 logger = LogManager.getLogger("SwaggerPetstoreAPIFramework");
		 		
	}
	
	@Test (priority = 1)
	public void testCreateOrder() {
		
		Response resp = StoreModuleRequests.createOrder(orderPayload);
		
		System.out.println("======================== POST Purchase Order Output ========================");
		// log response
		resp.then().log().all();
		
		// Validate response code
		Assert.assertEquals(resp.getStatusCode(), 200, "Check for POST status code");
		logger.info("POST request of STORE module successful using properties file and faker class data.");
	 }
	
	@Test (priority = 2, enabled = true)
	public void testPurchaseOrderById() {
		
		Response resp = StoreModuleRequests.getOrder(this.orderPayload.getId());
		
		System.out.println("======================== Get Purchase Data By ID Output ========================");
		// log response
		resp.then().log().all();
				
		// Validate response code
		Assert.assertEquals(resp.getStatusCode(), 200, "Check for GET status code");
		logger.info("GET request of STORE module successful using properties file and faker class data.");
	}
	
	@Test (priority = 3, enabled = true)
	public void testInvetory() {
		
		Response resp = StoreModuleRequests.getInventory();
		
		System.out.println("======================== Get Inventory Data Output ========================");
		// log response
		resp.then().log().all();
		
		// Validate response code
		Assert.assertEquals(resp.getStatusCode(), 200, "Check for inventory GET status code");
		logger.info("GET request of STORE module inventory successful using properties file and faker class data.");
	}
	
	@Test (priority = 4, enabled = true)
	public void deletePurchaseOrderById() {
		
		Response resp = StoreModuleRequests.deletePurchaseOrder(this.orderPayload.getId());
		
		System.out.println("======================== Delete Purchase Order By ID Output ========================");
		// log response
		resp.then().log().all();
		
		// Validate response code
		Assert.assertEquals(resp.getStatusCode(), 200, "Check for DELETE status code");
		logger.info("DELETE request of STORE module successful using properties file and faker class data.");
	}
}
