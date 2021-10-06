package qaautomation.august2021;
import com.github.javafaker.Faker;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeSuite;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import qaautomation.august2021.apis.APIEndpoints;
import qaautomation.august2021.apis.JsonPath;
import qaautomation.august2021.utils.APIUtility;


public abstract class BaseAPITest {
	RequestSpecification commonJsonSpec = new RequestSpecBuilder().setBaseUri("https://api-staging-builder.engineer.ai")
			.setContentType(ContentType.JSON).build().log().all();
	RequestSpecification loginJsonSpec;

	@BeforeSuite
	public void testLoginAPI() {
		Faker faker = new Faker();
		String firstname = faker.name().firstName();
		String lastname = faker.name().lastName();
		String email = faker.name().username() + "@gmail.com";
		String numberPhone = "+" + faker.phoneNumber().cellPhone();
		
		String payload = "{\"user\": {\"first_name\": \"" + firstname + "\", \"last_name\": \"" + lastname + "\", \"email\": \"" + email + "\", \"password\": \"12312313123\",\"phone_number\": \"" + numberPhone + "\"}}";
		Response response = given().spec(commonJsonSpec).body(payload).when().post(APIEndpoints.signup);
		assertEquals(response.statusCode(), 200);

		String token = APIUtility.getBodyDataUsingJsonPath(response, JsonPath.authToken);
		loginJsonSpec = new RequestSpecBuilder().setBaseUri("https://api-staging-builder.engineer.ai")
				.setContentType(ContentType.JSON).addHeader("authtoken", token).build().log().all();
	}
}
