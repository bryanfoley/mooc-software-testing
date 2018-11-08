package tudelft.ghappy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.internal.matchers.Null;

public class GHappyTest {
    private GHappy ghappy;

    @BeforeEach
    public void initialize() {
        this.ghappy = new GHappy();
    }

    @ParameterizedTest(name = "string = {0}")
    @CsvSource({"aaaaggbbbb","ggadfrevvgg"})
    public void longHappyString(String input) {
        boolean result = ghappy.gHappy(input);
        Assertions.assertTrue(result);
    }

    @ParameterizedTest(name = "string = {0}")
    @CsvSource({"gg","xx"})
    public void shortHappyString() {
        boolean result = ghappy.gHappy("gg");
        Assertions.assertTrue(result);
    }

    @ParameterizedTest(name = "string={0}")
    @CsvSource({"xxbbvvegrty", "gfgfgfgfgfg"})
    public void longUnhappyString(String input) {
        boolean result = ghappy.gHappy(input);
        Assertions.assertFalse(result);
    }
    @ParameterizedTest(name = "string={0}")
    @CsvSource({"gv", "xg"})
    public void shortUnhappyString(String input) {
        boolean result = ghappy.gHappy(input);
        Assertions.assertFalse(result);
    }

    @Test
    public void emptyString() {
        boolean result = ghappy.gHappy("");
        Assertions.assertTrue(result);
    }

    @Test
    public void nullInput() {
        boolean result = ghappy.gHappy(null);
        //Assertions.assertFalse(result);
    }

}
