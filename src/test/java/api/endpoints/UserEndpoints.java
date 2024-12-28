package api.endpoints;

import static io.restassured.RestAssured.given;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

//used to declaring static CRUD method operation
//this will take some payload (body)
//
public class UserEndpoints {

	//create
	public static Response createUser(User payload){
		
		Response response= given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
			
		.when().post(Routes.posturl);  //directly access by classanme , it is static
		
		return response;
		
	}
	
	//read
public static Response readUser(String username){
		
		Response response= given()
				.pathParam("username", username)
			
			
		.when().get(Routes.geturl);  //directly access by classanme , it is static
		
		return response;
	}

//update
public static Response updateUser(String username, User payload){
	
	Response response= given()
			.pathParam("username", username)
		    .body(payload)
		    .contentType(ContentType.JSON)
			.accept(ContentType.JSON)
		
	.when().put(Routes.updateurl);  //directly access by classanme , it is static
	
	return response;
}

//delete
public static Response deleteUser(String username){
	
	Response response= given()
			.pathParam("username", username)
		    
		
	.when().delete(Routes.updateurl);  //directly access by classanme , it is static
	
	return response;
}
}
