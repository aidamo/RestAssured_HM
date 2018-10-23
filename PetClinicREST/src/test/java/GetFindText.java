import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItems;

public class GetFindText {
    @BeforeClass
    public void setUp() {
        RestAssured.baseURI="https://api.twitter.com";
        RestAssured.basePath="/1.1/statuses/user_timeline.json";
    }

    @Test
    public void getAllPetTypes() {

        given().
                auth().
                oauth("r1SktL1rdaFe3jsF7uaC46uky", "M3Y72JtfLgNruQMXJloFlXPIpd61QGV2rERgNe9ZmSMlPLyO62", "4923063747-u2L19lo0t5L5k6I5XLGlMGVN6cq2qzMWDsahCVR", "O28DGNswrwhdcLD9ehv97TJPMqHZ7OyMZxVpOjsmTbgCQ").
                when().
                get().
                then().assertThat().body("text",hasItems("aidamo")).log().all();
    }

}
