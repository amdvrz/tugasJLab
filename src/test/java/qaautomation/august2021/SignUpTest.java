package qaautomation.august2021;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import qaautomation.august2021.apis.APIEndpoints;
import qaautomation.august2021.utils.APIUtility;


public class SignUpTest extends BaseAPITest {

	@Test
	public void signup() {
		Response response = given().spec(loginJsonSpec).when().post(APIEndpoints.signup);
		APIUtility.verifyStatusCode(response);
	}
	
//	@Test
//	public void dashboardAPIWithSchema() {
//		Response response = given().spec(loginJsonSpec).param("status", "completed").when().get(APIEndpoints.dashboard);
//		APIUtility.verifyStatusCode(response);
//		response.then().assertThat()
//				.body(matchesJsonSchema(DataUtility.getDataFromExcel("Schemas", "DashboardAPISchema")));
//	}
}
