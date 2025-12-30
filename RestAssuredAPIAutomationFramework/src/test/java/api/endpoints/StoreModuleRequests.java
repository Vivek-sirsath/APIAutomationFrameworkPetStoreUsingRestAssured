package api.endpoints;

import static io.restassured.RestAssured.given;
import java.util.ResourceBundle;

import api.payload.OrderPOJO;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class StoreModuleRequests {

	static ResourceBundle getURL() {

		// Create ResourceBundle Class object
		ResourceBundle routes = ResourceBundle.getBundle("routes");
		// No need to specify the full path of properties file.
		return routes;
	}

	public static Response createOrder(OrderPOJO payload) {

		// Specify request URL
		String store_post_order_url = getURL().getString("store_post_order_url");

		Response resp = given()
				.accept(ContentType.JSON)
				.contentType(ContentType.JSON)
				.body(payload)

				.when()
				.post(store_post_order_url);

		return resp;
	}

	public static Response getOrder(int orderId) {

		// Specify request URL
		String store_get_purchaseBy_orderId_url = getURL().getString("store_get_purchaseBy_orderId_url");

		Response resp = given()
				.accept(ContentType.JSON)
				.pathParam("orderId", orderId)

				.when()
				.get(store_get_purchaseBy_orderId_url);

		return resp;
	}

	public static Response deletePurchaseOrder(int orderId) {
		
		// Specify request URL in a string variable
		String store_del_order_url = getURL().getString("store_del_order_url");
		
		Response response = given()
				.accept(ContentType.JSON)
				.pathParam("orderId", orderId)

				.when()
				.delete(store_del_order_url);

		return response;

	}
	
	public static Response getInventory() {

		// Specify request URL in a string variable
		String store_get_inventory_url = getURL().getString("store_get_inventory_url");

		Response resp = given()
				.accept(ContentType.JSON)

				.when()
				.get(store_get_inventory_url);

		return resp;
	}
}
