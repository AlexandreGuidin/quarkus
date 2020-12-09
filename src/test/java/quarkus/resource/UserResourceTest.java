package quarkus.resource;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import quarkus.config.BaseResourceTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static quarkus.config.JsonMatcher.equalToJson;


@QuarkusTest
public class UserResourceTest extends BaseResourceTest {

    @Test
    public void list_empty() {
        given()
                .when()
                .get("/user")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body(is("[]"));
    }

    @Test
    public void save() {
        given()
                .when().body(readJson("json/resource/user/request/save_success.json"))
                .contentType(ContentType.JSON)
                .post("/user")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("id", notNullValue())
                .body("created_at", notNullValue())
                .body("document_number", is("123"))
                .body("info", equalToJson("json/resource/user/response/save_success_info.json"));
    }

    @Test
    public void save_invalid() {
        given()
                .when().body("{}")
                .contentType(ContentType.JSON)
                .post("/user")
                .then()
                .statusCode(422)
                .contentType(ContentType.JSON)
                .body(equalToJson("json/resource/user/response/save_invalid_fields.json"));
    }
}
