import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetPetTypeByID {

    @Test
    public void getPetTypeByID() {
        RestAssured.baseURI="http://bhdtest.endava.com:8080/petclinic/api";
        RestAssured.basePath="/pettypes/{petTypeID}";

        Response response = given().
                pathParam("petTypeID", 101).log().all().
                when().
                get().
                then().log().body().
                statusCode(HttpStatus.SC_OK).extract().response();
        String name = response.path("name");
        Assert.assertTrue(name.equals("Camel"));

        int id =response.path("id");
        Assert.assertEquals(id,101);
    }

}
