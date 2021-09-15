import com.codurance.Rover;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoverShould {

    private Rover target = new Rover();

    @ParameterizedTest
    @CsvSource({
            "R, E",
            "RR, S",
            "RRR, W",
            "RRRR, N",
            "RRRRR, E"
    })
    void rotate_right(String commands, String expectedOutput) {
        assertEquals(expectedOutput, target.execute(commands));
    }

    @ParameterizedTest
    @CsvSource({
            "L, W",
            "LL, S",
            "LLL, E",
            "LLLL, N",
            "LLLLL, W"
    })
    void rotate_left(String commands, String expectedOutput) {
        assertEquals(expectedOutput, target.execute(commands));
    }

//    @ParameterizedTest
//    @CsvSource()
}
