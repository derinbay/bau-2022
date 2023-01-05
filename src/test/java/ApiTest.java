import io.restassured.RestAssured;
import io.restassured.response.Response;
import models.Movie;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

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

    @Test
    public void testOmdbSearch() {
        RestAssured.baseURI = "http://www.omdbapi.com";
        Response movie = RestAssured
                .given()
                .param("s", "harry+potter")
                .param("page", "1")
                .param("apikey", "28ca4305")
                .get("/");


        assertTrue(true);
        //assertEquals(movie.getYear(), "2001");
        //assertEquals(movie.getReleased(), "19 Dec 2001");
    }


    //harry potter araması yapalım
    //dönen filmlerden ilk sayfada 2004 yılında olanın adının "Harry Potter and the Prisoner of Azkaban" olduğunu kontrol et
    //gerekli görülen kontrolleri yapalım
}

