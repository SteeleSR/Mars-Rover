import com.codurance.Rover;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoverShould {

    private Rover target = new Rover();

    @ParameterizedTest
    @CsvSource({
            "R, 0:0:E",
            "RR, 0:0:S",
            "RRR, 0:0:W",
            "RRRR, 0:0:N",
            "RRRRR, 0:0:E"
    })
    void rotate_right(String commands, String expectedOutput) {
        assertEquals(expectedOutput, target.execute(commands));
    }

    @ParameterizedTest
    @CsvSource({
            "L, 0:0:W",
            "LL, 0:0:S",
            "LLL, 0:0:E",
            "LLLL, 0:0:N",
            "LLLLL, 0:0:W"
    })
    void rotate_left(String commands, String expectedOutput) {
        assertEquals(expectedOutput, target.execute(commands));
    }

    @ParameterizedTest
    @CsvSource({
            "M, 0:1:N",
            "RRM, 0:9:S"
    })
    void move_longitudinally(String commands, String expectedOutput) {
        assertEquals(expectedOutput, target.execute(commands));
    }

    @ParameterizedTest
    @CsvSource({
            "LM, 9:0:W",
            "RM, 1:0:E"
    })
    void move_latitudinally(String commands, String expectedOutput) {
        assertEquals(expectedOutput, target.execute(commands));
    }

}
