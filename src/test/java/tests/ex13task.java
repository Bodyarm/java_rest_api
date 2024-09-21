package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import lib.BaseTestCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ex13task extends BaseTestCase {



    @Test
    public void testCheckUserAgent() {
        Map<String,String> headers = new HashMap<>();
        headers.put("User Agent","Mozilla/5.0 (Linux; U; Android 4.0.2; en-us; Galaxy Nexus Build/ICL53F) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30" );
//        headers.put("user_agent","Mozilla/5.0 (Linux; U; Android 4.0.2; en-us; Galaxy Nexus Build/ICL53F) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30" );

        Response responseAgent = RestAssured
                .given()
                .headers(headers)
//            'platform': 'Mobile', 'browser': 'No', 'device': 'Android'
//                .queryParam("platform","Mobile")
//                .queryParam("browser","No")
//                .queryParam("device","Android")
                .when()
                .get("https://playground.learnqa.ru/ajax/api/user_agent_check")
                .andReturn();

        System.out.println(responseAgent.getStatusCode()+ " "+responseAgent.getStatusLine());
        System.out.println("-----------------------------");
        responseAgent.print();
        System.out.println("-----------------------------");

    }
}
