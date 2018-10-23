import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PutPetType {

    @Test
    public void putPetType() {
        RestAssured.baseURI="http://bhdtest.endava.com:8080/petclinic/api";
        RestAssured.basePath="/pettypes/";

        given().
                contentType(ContentType.JSON).
                pathParam("petTypeID", 130).
                body("{\"name\":\"zebra\"}").
                when().
                put("{petTypeID}").
                then().
                statusCode(HttpStatus.SC_NO_CONTENT);

    }
}
