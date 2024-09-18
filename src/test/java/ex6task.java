import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;
import io.restassured.http.Headers;

public class ex6task {

    @Test
    public void ex6task(){

        Response response = RestAssured
                .given()
                .redirects()
                .follow(false)
                .when()
                .get(" https://playground.learnqa.ru/api/long_redirect")
                .andReturn();


        String responseLocation = response.getHeaders().getValue("Location");
        System.out.println(responseLocation);



    }
}
