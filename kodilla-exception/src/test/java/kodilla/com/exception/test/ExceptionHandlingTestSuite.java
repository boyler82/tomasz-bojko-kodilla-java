package kodilla.com.exception.test;

import com.kodilla.exception.test.SecondChallenge;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ExceptionHandlingTestSuite {

    @Test
    void testExceptionHandlingWithCorrectValues() {
//                given
        SecondChallenge secondChallenge = new SecondChallenge();
//                when
//                then
        assertAll(
                () -> assertDoesNotThrow(() -> secondChallenge.probablyIWillThrowException(1.5, 1)),
                () -> assertDoesNotThrow(() -> secondChallenge.probablyIWillThrowException(1.1, 0.5))
                );
    }
    @Test
    void testExceptionHandlingThrowsException(){
        //                given
        SecondChallenge secondChallenge = new SecondChallenge();
//                when
//                then
        assertAll(
                () -> assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(2, 1.5)),
                () -> assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(-1, 1.5))
                );
    }
}
