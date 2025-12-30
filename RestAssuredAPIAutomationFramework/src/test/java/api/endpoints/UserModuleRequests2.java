
/*
 - 1st WAY : Using (Routes.java) Class
 - In this class, we're creating and sending the requests.
 - In this class we're fetching the values of the endpoints from Routes.java Class. 
  (requests_urls) e.g. post_user_url, get_user_url, put_user_url, del_user_url 
  
  - 2nd WAY : Using (Routes.properties) File 
  - Create another class (UserModuleRequests2.java) to implement (Routes.properties)
  - Ref : UserModuleRequests2.java
 */

package api.endpoints;

import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import api.payload.UserPOJO;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserModuleRequests2 {
	
	static ResourceBundle getURL() {
		
		ResourceBundle routes = ResourceBundle.getBundle("routes");
		// No need to specify the full path of properties file. 
		return routes;
	}

	public static Response createUser(UserPOJO payload) {
		
		// We need to store the path in a String variable, fetched from properties file.
		String post_user_url = getURL().getString("post_user_url"); // key in 'routes.properties' 
		
		Response response = given()
				.accept(ContentType.JSON)
				.contentType(ContentType.JSON)
				.body(payload)

				.when()
				.post(post_user_url);

		return response;

	}
	
	public static Response getUser(String userName) {
		
		// We need to store the path in a String variable, fetched from properties file.
		String get_user_url = getURL().getString("get_user_url"); // key in 'routes.properties'
		
		Response response = given()
				.accept(ContentType.JSON)
				.pathParam("username", userName)

				.when()
				.get(get_user_url);

		return response;

	}
	
	public static Response updateUser(String userName, UserPOJO payload) {
		
		// We need to store the path in a String variable, fetched from properties file.
		String put_user_url = getURL().getString("put_user_url"); // key in 'routes.properties'
		
		Response response = given()
				.accept(ContentType.JSON)
				.contentType(ContentType.JSON)
				.pathParam("username", userName)
				.body(payload)

				.when()
				.put(put_user_url);

		return response;

	}
	
	public static Response deleteUser(String userName) {
		
		// We need to store the path in a String variable, fetched from properties file.
		String del_user_url = getURL().getString("del_user_url"); // key in 'routes.properties'
		
		Response response = given()
				.accept(ContentType.JSON)
				.pathParam("username", userName)

				.when()
				.delete(del_user_url);

		return response;

	}
}
