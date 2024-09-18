import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;

public class ex7task {

    @Test
    public void ex7taskTest(){

        Response response = RestAssured
                .given()
                .redirects()
                .follow(false)
                .when()
                .get("https://playground.learnqa.ru/api/long_redirect")
                .andReturn();

        int responseStatus = response.getStatusCode();
        String responseLocation = response.getHeaders().getValue("Location");

        while(responseStatus!=200){
            response = RestAssured
                    .given()
                    .redirects()
                    .follow(false)
                    .when()
                    .get(responseLocation)
                    .andReturn();
            responseStatus=response.getStatusCode();
            //Если доходим до 200тки, то заголовка Location Не будет и мы получим null
            //Поэтому в переменной оставлем URL на который мы уже пришли
            if(responseStatus!=200) responseLocation = response.getHeaders().getValue("Location");
        }

        System.out.println(responseLocation);


    }
}
