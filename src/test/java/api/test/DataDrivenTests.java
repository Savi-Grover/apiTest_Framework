package api.test;
import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndpoints;
import api.payload.User;
import api.utilities.apiDataProvider;
import io.restassured.response.Response;

public class DataDrivenTests {

	//we will refer getAllaData from dataProviders
	@Test (priority=1,dataProvider="Data", dataProviderClass=apiDataProvider.class)
	public void testPostUser(String userID, String username, String fname, String lname, String useremail, String passowrd, String ph) 
	{
		
		
		//we will now create payload
		User userPayload= new User();
		userPayload.setUsername(username);
		userPayload.setFirstname(fname);
		userPayload.setLastname(lname);
		userPayload.setEmail(useremail);
		userPayload.setPassword(passowrd);
		userPayload.setPhone(ph);
		
		Response response=UserEndpoints.createUser(userPayload);
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	
	// we are deleting all users created above
	@Test (priority=2,dataProvider="UserNames", dataProviderClass=apiDataProvider.class)
	public void testDeleteUser(String username) {
		
		
		//we will now create payload
		Response response=UserEndpoints.deleteUser(username);
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
}
