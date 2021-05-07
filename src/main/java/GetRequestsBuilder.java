import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static io.restassured.RestAssured.given;

/**
 * * This is my main GetRequestBuilder class in which I have implemented a method to build and send the GET requests and then,
 * retrieve the response body as a list of objects.
 * I'm using RestAssured which is DSL for JAVA API testing to perform this testing.
 * @Author Eliecer Cordero
 * */

public class GetRequestsBuilder {
    /**
     * This method builds and send the GET request and retrieves the response body as a List of objects.
     * @Param apiKey: api.nasa.gov key for expanded usage.
     * @Param marsSolOrEarthDay: corresponding date on earth for the given sol number.
     * @Param roverName: corresponding NASA rover´s name
     * @return The response body as A list of objects.
     * */

    public List<Object> getMarsPhotosRequestsBuilderForNASARover(String apiKey, String marsSolOrEarthDay, String roverName){
        Map<String,String> parameters = new HashMap<>();
        parameters.put("api_key",apiKey);
        if ((marsSolOrEarthDay.contains("-"))) {
            parameters.put("earth_date", marsSolOrEarthDay);
        } else {
            parameters.put("sol", marsSolOrEarthDay);
        }
        return  given()
                    .pathParam("rover", roverName)
                    .queryParams(parameters)
                    .when().get("https://api.nasa.gov/mars-photos/api/v1/rovers/{rover}/photos")
                    .then().assertThat().statusCode(200)
                    .extract().body().jsonPath().getList("photos");
    }
}
