package lib;

import io.restassured.http.Headers;
import io.restassured.response.Response;
import java.util.Map;

import static org.hamcrest.Matchers.hasKey;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BaseTestCase {

    protected String getHeader(Response Responose, String name){
        Headers headers = Responose.getHeaders();

        assertTrue(headers.hasHeaderWithName(name),"Response doesn't have header with name "+name);
        return headers.getValue(name);
    }

    protected String getCookies(Response Response, String name){
        Map<String,String> cookies= Response.getCookies();

        assertTrue(cookies.containsKey(name),"Response doesn't have cookie with name "+name);
        return cookies.get(name);
    }

    protected int getIntFromJson(Response Response, String name){
        Response.then().assertThat().body("$",hasKey(name));
        return Response.jsonPath().getInt(name);
    }

    protected String getStringFromJson(Response Response, String name){
        Response.then().assertThat().body("$",hasKey(name));
        return Response.jsonPath().getString(name);
    }

}
