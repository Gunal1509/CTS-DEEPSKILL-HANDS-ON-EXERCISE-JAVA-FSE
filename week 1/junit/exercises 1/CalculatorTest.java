package junit_exercises;

import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {

    @Test
    public void testAdd() {

        Calculator c = new Calculator();

        assertEquals(30, c.add(10, 20));

    }
}