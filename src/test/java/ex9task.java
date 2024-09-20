import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;


public class ex9task {

    @Test
    public void ex9taskTest(){

        String[] passwordPull = {
                "1234",                "12345",                "111111",                "121212",
                "123123",                "123456",                "555555",                "654321",
                "666666",                "696969",                "888888",                "1234567",
                "7777777",                "12345678",                "123456789",                "1234567890",
                "!@#$%^&*",                "000000",                "123qwe",                "1q2w3e4r",
                "1qaz2wsx",                "aa123456",                "abc123",                "access",
                "admin",                "adobe123",                "ashley",                "azerty",
                "bailey",                "baseball",                "batman",                "charlie",
                "donald",                "dragon",                "flower",                "Football",
                "freedom",                "hello",                "hottie",                "iloveyou",
                "jesus",                "letmein",                "login",                "lovely",
                "loveme",                "master",                "michael",                "monkey",
                "mustang",                "ninja",                "passw0rd",                "password",
                "password1",                "photoshop",                "princess",                "qazwsx",
                "qwerty",                "qwerty123",                "qwertyuiop",                "shadow",
                "solo",                "starwars",                "sunshine",                "superman",
                "trustno1",                "welcome",                "whatever",                "zaq1zaq1"
        };
        String username = "super_admin";
        String cookie;
        Response response;

        for(int i=0;i < passwordPull.length;i++ ){

            System.out.println(i +" Check password: "+passwordPull[i]);

            response = RestAssured
                    .given()
                    .queryParam("login",username)
                    .queryParam("password",passwordPull[i])
                    .post("https://playground.learnqa.ru/ajax/api/get_secret_password_homework")
                    .andReturn();

            cookie = response.getCookie("auth_cookie");

            System.out.println(i +" Got auth_cookie:"+ cookie);

            response = RestAssured
                    .given()
                    .queryParam("login","super_admin")
                    .queryParam("password",passwordPull[i])
                    .cookies("auth_cookie",cookie)
                    .when()
                    .post("https://playground.learnqa.ru/ajax/api/check_auth_cookie")
                    .andReturn();

              if (!response.print().equals("You are NOT authorized")) {
                  System.out.println(i + " Correct password is:"+passwordPull[i]);
                  break;
              }
        }
    }
}
