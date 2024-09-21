package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import lib.BaseTestCase;
import org.junit.jupiter.api.Test;
import io.restassured.http.Headers;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ex12task extends BaseTestCase {


    @Test
    public void checkCookieTest(){
        Response responseCheckAuth = RestAssured
                .get("https://playground.learnqa.ru/api/homework_header")
                .andReturn();
//        x-secret-homework-header=Some secret value
        String header = this.getHeader(responseCheckAuth,"x-secret-homework-header");
        assertEquals("Some secret value",header,"Wrong value for SuperDrupeer Secret Header");
    }

}
