package com.kodilla.patterns.singleton;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class LoggerTestSuit {

    private Logger logger;

    @BeforeEach
    void setUp() {
        logger = Logger.INSTANCE;
    }

    @Test
    void testLogger() {
//        Given
    String testLog = "Test one";
//        When
        logger.log(testLog);
//        Then
        assertEquals(testLog, logger.getLastLog());
    }

    @Test
    void testLastLogger() {
//        Given
        String firstLog = "Logg one";
        String secondLog = "Logg two";
//        When
        logger.log(firstLog);
        logger.log(secondLog);
//        Then
        assertEquals(secondLog,logger.getLastLog());

    }
}
