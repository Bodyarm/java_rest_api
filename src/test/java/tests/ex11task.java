package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import lib.BaseTestCase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ex11task extends BaseTestCase {


    @Test
    public void checkCookieTest(){
        Response responseCheckAuth = RestAssured
                .get("https://playground.learnqa.ru/api/homework_cookie")
                .andReturn();

        //HomeWork -> hw_value
        assertEquals("hw_value",responseCheckAuth.getCookie("HomeWork"),"Response doesn't have expected cookie HomeWork with value hw_value");





    }

}
