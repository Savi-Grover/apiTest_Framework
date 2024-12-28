package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.github.scribejava.core.model.Response;
import io.restassured.response.Response;

import api.endpoints.UserEndpoints;
import api.payload.User;

//4 tests required-
//post
//get
//update
//delete
public class UserTests {

	Faker faker;
	User userPayload;
	@BeforeClass
	public void setupData() {
		//create data prior to test using faker lib
	faker=new Faker();
	
	//to pass faker data to pojo class
	userPayload=new User();
	
	//creating all data and passing to pojo class
	userPayload.setId(faker.idNumber().hashCode());
	userPayload.setUsername(faker.name().username());
	userPayload.setFirstname(faker.name().firstName());
	userPayload.setLastname(faker.name().lastName());
	userPayload.setEmail(faker.internet().safeEmailAddress());
	userPayload.setPassword(faker.internet().password(5,10));
	userPayload.setPhone(faker.phoneNumber().cellPhone());
	
	
	}
	
	//post testcase
	@Test(priority=1)
	public void testPostUser(){
		
		//call create method
		io.restassured.response.Response response=UserEndpoints.createUser(userPayload);
		response.then().log().all();
		
		//we can put all validations.
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	

}


