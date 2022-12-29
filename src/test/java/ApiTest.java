import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import models.Movie;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ApiTest {

    //https://www.omdbapi.com/?t=the+lord+of+the+rings&y=2001&apikey=28ca4305&plot=full
    //https://basepath/path/queryparams
    @Test
    public void testOmdb() {
        RestAssured.baseURI = "http://www.omdbapi.com";
        Movie movie = RestAssured
                .given()
                .param("t", "the+lord+of+the+rings")
                .param("y", "2001")
                .param("plot", "full")
                .param("apikey", "28ca4305")
                .get("/")
                .then()
                .extract()
                .as(Movie.class);

        assertTrue(movie.getTitle().contains("Lord of the Rings"));
        assertEquals(movie.getYear(), "2001");
        assertEquals(movie.getReleased(), "19 Dec 2001");
    }
}

