import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

public class ex5task {

    @Test
    public void ex5task(){

        JsonPath response = RestAssured
                .get("https://playground.learnqa.ru/api/get_json_homework")
                .jsonPath();

        String checkuli = response.get("messages.message[1]");
        System.out.println(checkuli);


    }
}
