import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class ex10task {

    @ParameterizedTest
    @ValueSource(strings = {"Less15","Exactlyyyyyyy15","Mooooooooooooooooorethan15",""})
    public void ex10taskTest(String name) {

        assertTrue(name.length()>15,"Current String '"+ name + "' is below 15 symbols");

    }
}
