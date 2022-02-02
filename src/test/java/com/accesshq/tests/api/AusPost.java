package com.accesshq.tests.api;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;




public class AusPost {
    @Test
    void testPostCodeSearch()
    {
            given().
                    param("q","Tascott", "state", "NSW").and().header("Auth-key","c912db24-d4be-4303-97ff-92f940a58b8b").
            when().
                    get("https://digitalapi.auspost.com.au/postcode/search.json").
            then().
                    assertThat().statusCode(200).and().body("localities.locality.postcode", equalTo(2250));

    }
}
