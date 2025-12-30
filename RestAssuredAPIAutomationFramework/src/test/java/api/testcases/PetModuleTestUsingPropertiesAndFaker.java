package api.testcases;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.PetModuleRequests;
import api.endpoints.StoreModuleRequests;
import api.payload.CategoryPOJO;
import api.payload.PetPOJO;
import api.payload.TagPOJO;
import io.restassured.response.Response;

public class PetModuleTestUsingPropertiesAndFaker {

	    // Create an object of PetPOJO Class which will accept fake data.
		Faker faker;
		PetPOJO petPayload;
		public static Logger logger;
		
		
		@BeforeTest
		public void generateTestData() {
			
			// Initialize Faker class object
			faker = new Faker();
			petPayload = new PetPOJO();
			
			// Initialize CategoryPOJO class
			CategoryPOJO category = new CategoryPOJO();
			category.setId(1);
			category.setName("Dogs");
			
			// Initialize TagPOJO class
			TagPOJO tag = new TagPOJO();
			tag.setId(1);
			tag.setName("German Shephard");
			
			// Initialize PetPOJO class and create payload			
			petPayload.setId(faker.number().numberBetween(1000, 9999));
			petPayload.setCategory(category);
			petPayload.setName("Lucy-Updated");
			
			List<String> photoUrls = new ArrayList<String>();
			photoUrls.add("https://example.com/dog.jpg");
			
			List<TagPOJO> tags = new ArrayList<TagPOJO>();
			tags.add(tag);
			
			petPayload.setPhotoUrls(photoUrls);
			petPayload.setTags(tags);
			petPayload.setStatus("pending");
			
			// Obtain logger and pass the name of the logger
			 logger = LogManager.getLogger("SwaggerPetstoreAPIFramework");			 		
		}
		
		@Test (priority = 1)
		public void testAddNewPet() {
			
			Response resp = PetModuleRequests.addNewPetToStore(petPayload);
			
			System.out.println("======================== POST New Pet Output ========================");
			// log response
			resp.then().log().all();
			
			// Validate response code
			Assert.assertEquals(resp.getStatusCode(), 200, "Check for POST status code");
			logger.info("POST request of PET module successful using properties file and faker class data.");
		 }
		
		@Test (priority = 2, enabled = true)
		public void testFindPetById() {
			
			Response resp = PetModuleRequests.findPetById(this.petPayload.getId());
			
			System.out.println("======================== Get Pet By ID Output ========================");
			// log response
			resp.then().log().all();
					
			// Validate response code
			Assert.assertEquals(resp.getStatusCode(), 200, "Check for GET status code");
			logger.info("GET by ID request of PET module successful using properties file and faker class data.");
		}
		
		@Test (priority = 3, enabled = true)
		public void testFindPetByStatus() {
			
			Response resp = PetModuleRequests.findPetByStatus(this.petPayload.getStatus());
			
			System.out.println("======================== Get Pet By Status Output ========================");
			// log response
			resp.then().log().all();
					
			// Validate response code
			Assert.assertEquals(resp.getStatusCode(), 200, "Check for GET status code");
			logger.info("GET by STATUS request of PET module successful using properties file and faker class data.");
		}
		
		@Test (priority = 4, enabled = true)
		public void testUpdateExistingPet() {
			
			Response resp = PetModuleRequests.updateExistingPet(petPayload);
			
			System.out.println("======================== Update Pet Name Output ========================");
			// log response
			resp.then().log().all();
					
			// Validate response code
			Assert.assertEquals(resp.getStatusCode(), 200, "Check for GET status code");
			logger.info("UPDATE request of PET module successful using properties file and faker class data.");
		}
		
		@Test (priority = 5, enabled = true)
		public void testDeletePetById() {
			
			Response resp = PetModuleRequests.deletePetById(this.petPayload.getId(), "special-key");
			
			System.out.println("======================== Delete Pet By Id Output ========================");
			// log response
			resp.then().log().all();
					
			// Validate response code
			Assert.assertEquals(resp.getStatusCode(), 200, "Check for GET status code");
			logger.info("DELETE request of PET module successful using properties file and faker class data.");
		}
}
