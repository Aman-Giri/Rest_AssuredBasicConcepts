package restAssuredConcepts;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class SendingPostRequest_withMethodChaining {
	public static void main(String[] args) {
		//Build the Request
		RestAssured
			.given()
			.log()
			.all()
			.baseUri("https://restful-booker.herokuapp.com/")
			.basePath("booking")
			.body("{\r\n"
					+ "    \"firstname\" : \"Jim\",\r\n"
					+ "    \"lastname\" : \"Brown\",\r\n"
					+ "    \"totalprice\" : 111,\r\n"
					+ "    \"depositpaid\" : true,\r\n"
					+ "    \"bookingdates\" : {\r\n"
					+ "        \"checkin\" : \"2018-01-01\",\r\n"
					+ "        \"checkout\" : \"2019-01-01\"\r\n"
					+ "    },\r\n"
					+ "    \"additionalneeds\" : \"Breakfast\"\r\n"
					+ "}")
			.contentType(ContentType.JSON)
			//Hit the Request and get the response 
			.post()
			//validate the response
			.then()
			.log()
			.all()
			.statusCode(200);
	}
}
