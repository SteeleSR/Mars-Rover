import com.codurance.Coordinate;
import com.codurance.Rover;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Optional;

import static java.util.Optional.empty;
import static java.util.Optional.of;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoverShould {

    private Rover target = new Rover(empty());

    @ParameterizedTest
    @CsvSource({
            "R, 0:0:E",
            "RR, 0:0:S",
            "RRR, 0:0:W",
            "RRRR, 0:0:N",
            "RRRRR, 0:0:E"
    })
    void rotate_right(String command, String expectedOutput) {
        assertEquals(expectedOutput, target.execute(command));
    }

    @ParameterizedTest
    @CsvSource({
            "L, 0:0:W",
            "LL, 0:0:S",
            "LLL, 0:0:E",
            "LLLL, 0:0:N",
            "LLLLL, 0:0:W"
    })
    void rotate_left(String command, String expectedOutput) {
        assertEquals(expectedOutput, target.execute(command));
    }

    @ParameterizedTest
    @CsvSource({
            "M, 0:1:N",
            "RRM, 0:9:S"
    })
    void move_latitudinally(String command, String expectedOutput) {
        assertEquals(expectedOutput, target.execute(command));
    }

    @ParameterizedTest
    @CsvSource({
            "LM, 9:0:W",
            "RM, 1:0:E"
    })
    void move_longitudinally(String command, String expectedOutput) {
        assertEquals(expectedOutput, target.execute(command));
    }

    @Test void
    avoid_obstacle() {
        Rover target = new Rover(of(new Coordinate(0, 3)));

        assertEquals("O:0:2:N", target.execute("MMMM"));
    }

    @ParameterizedTest
    @CsvSource({
            "MMRMMLM, 2:3:N",
            "MMMMMMMMMM, 0:0:N"
    })
    void execute_complex_command(String command, String expectedOutput) {
        assertEquals(expectedOutput, target.execute(command));
    }

}
