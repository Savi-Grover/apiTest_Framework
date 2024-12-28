package api.endpoints;
//capture all urls(baseurl+endpoint) from swagger

//create user with body- https://petstore.swagger.io/v2/user/createWithList
//get user- https://petstore.swagger.io/v2/user/{username}
//put-      https://petstore.swagger.io/v2/user/{username}
//delete-	https://petstore.swagger.io/v2/user/{username}

public class Routes {

	//user can be kept as id model  is store, or pet, user is changed to model, pet
	public static String base_url="https://petstore.swagger.io/v2";
	
	//user model
	public static String posturl=base_url+"/user";
	public static String geturl=base_url+"/user/{username}";
	public static String updateurl=base_url+"/user/{username}";
	public static String delete_url=base_url+"/user/{username}";
	
	//store module urls
	   // create store endpoints
	
	//pet module urls
}
