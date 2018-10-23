import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.equalTo;

public class PostPetType {

    @Test
    public void postPetType() {
        RestAssured.baseURI="http://bhdtest.endava.com:8080/petclinic/api";
        RestAssured.basePath="/pettypes";

        given().
                contentType(ContentType.JSON).
                body("{\"name\":\"zebra\"}").
                when().
                post().
                then().
                statusCode(HttpStatus.SC_CREATED).
        body("name",equalTo("zebra"));
    }
}
