package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import lib.BaseTestCase;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.sql.SQLOutput;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ex13task extends BaseTestCase {

    String gplatform;
    String gbrowser;
    String gdevice;

    @ParameterizedTest
    @CsvSource(
    { "'Mozilla/5.0 (Linux; U; Android 4.0.2; en-us; Galaxy Nexus Build/ICL53F) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30','Mobile','No','Android'",
      "'Mozilla/5.0 (iPad; CPU OS 13_2 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) CriOS/91.0.4472.77 Mobile/15E148 Safari/604.1','Mobile','Chrome','iOs'",
      "'Mozilla/5.0 (compatible; Googlebot/2.1; +http://www.google.com/bot.html)','Googlebot','Unknown', 'Unknown'",
      "'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.77 Safari/537.36 Edg/91.0.100.0','Web','Chrome','No'",
      "'Mozilla/5.0 (iPad; CPU iPhone OS 13_2_3 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/13.0.3 Mobile/15E148 Safari/604.1','Mobile','No','iPhone'"
    })
    public void testCheckUserAgent(String userAgentInfo, String platform, String browser, String device) {


        Response responseAgent = RestAssured
                .given()
                .headers("user-agent",userAgentInfo)
                .when()
                .get("https://playground.learnqa.ru/ajax/api/user_agent_check")
                .andReturn();

        gplatform = this.getStringFromJson(responseAgent,"platform");
        gbrowser = this.getStringFromJson(responseAgent,"browser");
        gdevice = this.getStringFromJson(responseAgent,"device");

        System.out.println("User Agent is "+userAgentInfo);
        System.out.println("Ожидаем: "+ platform +" "+ browser + " "+ device);
        System.out.println("Получили: "+ gplatform +" "+ gbrowser + " "+ gdevice);

        assertEquals(platform, gplatform,"Wrong platform");
        assertEquals(browser,gbrowser, "Wrong browser");
        assertEquals(device,gdevice,"wrong device");

    }

}
