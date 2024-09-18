import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;


public class ex8task {

    @Test
    public void ex8taskTest(){
        JsonPath jsonResponse;

        jsonResponse = RestAssured
                .get("https://playground.learnqa.ru/ajax/api/longtime_job")
                .jsonPath();

        String token =jsonResponse.get("token");
        int seconds = jsonResponse.get("seconds");

        System.out.println(token + " Time to wait: "+ seconds);

        jsonResponse = RestAssured
                .given()
                .queryParam("token", token)
                .get("https://playground.learnqa.ru/ajax/api/longtime_job")
                .jsonPath();

        System.out.println(token + " Current status:"+ jsonResponse.get("status"));

        try {
            System.out.println("Waiting "+seconds +" seconds");
            Thread.sleep(seconds * 1000+100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        jsonResponse = RestAssured
                .given()
                .queryParam("token", token)
                .get("https://playground.learnqa.ru/ajax/api/longtime_job")
                .jsonPath();

        System.out.println(token + " Current status: "+ jsonResponse.get("status"));
        System.out.println(token + " Result is "+ jsonResponse.get("result"));



    }
}
