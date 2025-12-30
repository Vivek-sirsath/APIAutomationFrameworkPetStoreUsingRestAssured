// Routes Class only contains the URLs

package api.endpoints;

public class Routes {
	
	public static String base_url = "https://petstore.swagger.io/v2";
	
	//  =======================  User Module URLs =======================	
	/*
	Create User    POST     https://petstore.swagger.io/v2/user
    Get User       GET      https://petstore.swagger.io/v2/user/{username}
    Update User    PUT      https://petstore.swagger.io/v2/user/{username}
    Delete User    DELETE   https://petstore.swagger.io/v2/user/{username}
    
	*/
	public static String post_user_url = base_url + "/user";
	public static String get_user_url = base_url + "/user/{username}";
	public static String put_user_url = base_url + "/user/{username}";
	public static String del_user_url = base_url + "/user/{username}";
	
	
	//  =======================  Pet Module URLs =======================	
	/*
	Add New Pet    POST     https://petstore.swagger.io/v2/pet
    Get Pet        GET      https://petstore.swagger.io/v2/pet/{petId}
    Update User    PUT      https://petstore.swagger.io/v2/pet
   
    
	*/
	
	// Store Module URLs
	
}
