import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class ex10task {

    @ParameterizedTest
    @ValueSource(strings = {"Less15","Exactlyyyyyyy15","Mooooooooooooooooorethan15","nulltest"})
    public void ex10taskTest(String name) {

        if( name.equals("nulltest")) name =null;
        try {
            assertTrue(name.length() > 15, "Current String '" + name + "' is below 15 symbols");
        } catch (NullPointerException e){
            assertTrue(false,"Current String is null");
        }
    }
}
