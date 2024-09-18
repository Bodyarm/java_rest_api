import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.http.Headers;
import org.junit.jupiter.api.Test;


import java.util.HashMap;
import java.util.Map;

public class HelloWorldTest {
    @Test
    public void testRestAssured(){

        Map<String,String>data = new HashMap<>();
        data.put("login","secret_login");
        data.put("password","secret_pass");

        Response responseForGet = RestAssured
                .given()
                .body(data)
                .when()
                .get("https://playground.learnqa.ru/api/get_auth_cookie")
                .andReturn();

        String responseCookie = responseForGet.getCookie("auth_cookie");

        System.out.println("auth_cookie is "+responseCookie);

        Map<String,String> cookies = new HashMap<>();
        if(responseCookie!=null)
            cookies.put("auth_cookie",responseCookie);


        Response responseForCheck = RestAssured
                .given()
                .body(data)
                .cookies(cookies)
                .when()
                .post("https://playground.learnqa.ru/api/check_auth_cookie")
                .andReturn();

        responseForCheck.print();

//        System.out.println("\n Pretty text:");
//        responseForGet.prettyPrint();
//
//        System.out.println("\n Headers:");
//        Headers headers = responseForGet.getHeaders();
//        System.out.println(headers);
//
//        System.out.println("\n Cookies");
//        Map<String,String> responseCookies = responseForGet.getCookies();
//        System.out.println(responseCookies);

//        String responseCookie = response.getCookie("auth_cookie");
//        System.out.println(responseCookie);

    }
}
