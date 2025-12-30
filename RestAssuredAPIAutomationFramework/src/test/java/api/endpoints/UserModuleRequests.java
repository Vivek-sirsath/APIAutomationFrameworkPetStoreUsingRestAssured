
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

import api.payload.UserPOJO;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserModuleRequests {

	public static Response createUser(UserPOJO payload) {
		Response response = given()
				.accept(ContentType.JSON)
				.contentType(ContentType.JSON)
				.body(payload)

				.when()
				.post(Routes.post_user_url);

		return response;

	}
	
	public static Response getUser(String userName) {
		Response response = given()
				.accept(ContentType.JSON)
				.pathParam("username", userName)

				.when()
				.get(Routes.get_user_url);

		return response;

	}
	
	public static Response updateUser(String userName, UserPOJO payload) {
		Response response = given()
				.accept(ContentType.JSON)
				.contentType(ContentType.JSON)
				.pathParam("username", userName)
				.body(payload)

				.when()
				.put(Routes.put_user_url);

		return response;

	}
	
	public static Response deleteUser(String userName) {
		Response response = given()
				.accept(ContentType.JSON)
				.pathParam("username", userName)

				.when()
				.delete(Routes.del_user_url);

		return response;

	}
}
