package api.endpoints;

import static io.restassured.RestAssured.given;
import java.util.ResourceBundle;

import api.payload.PetPOJO;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PetModuleRequests {

	// Create static getURL() method
	static ResourceBundle getURL() {

		// Create ResourceBundle Class object
		ResourceBundle routes = ResourceBundle.getBundle("routes");
		// No need to specify the full path of properties file.
		return routes;
	}

	public static Response addNewPetToStore(PetPOJO payload) {

		// Specify POST request URL
		String pet_post_url = getURL().getString("pet_post_url");

		Response resp = given()
				.accept(ContentType.JSON)
				.contentType(ContentType.JSON)
				.body(payload)
				
				.when()
				.post(pet_post_url);

		return resp;
	}

	public static Response findPetById(long id) {

		// Specify GET request URL
		String pet_get_by_Id_url = getURL().getString("pet_get_by_Id_url");

		// Perform GET request and store the response in a 'resp' variable.
		Response resp = given()
				.accept(ContentType.JSON)
				.pathParam("petId", id)
				
				.when()
				.get(pet_get_by_Id_url);

		return resp;
	}

	public static Response findPetByStatus(String status) {

		// Specify GET request URL
		String pet_get_by_status_url = getURL().getString("pet_get_by_status_url");

		// Perform GET request and store the response in a 'resp' variable.
		Response resp = given()
				.accept(ContentType.JSON)
				.queryParam("status", status)
				
				.when()
				.get(pet_get_by_status_url);

		return resp;
	}

	public static Response updateExistingPet(PetPOJO payload) {

		// Specify PUT request URL
		String pet_put_url = getURL().getString("pet_put_url");

		// Perform GET request and store the response in a 'resp' variable.
		Response resp = given()
				.accept(ContentType.JSON)
				.contentType(ContentType.JSON)
				.body(payload)
				
				.when()
				.put(pet_put_url);

		return resp;
	}

	public static Response deletePetById(long id, String apiKey) {

		// Specify DELETE request URL
		String pet_delete_url = getURL().getString("pet_delete_url");

		// Perform GET request and store the response in a 'resp' variable.
		Response resp = given()
				.accept(ContentType.JSON)
				.header("api_key", apiKey)
				.pathParam("petId", id)
				
				.when()
				.delete(pet_delete_url);

		return resp;
	}
}
