package junit_exercises;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class AAAPatternTest {

    AAAPattern AAAPattern;

    @Before
    public void setUp() {

        System.out.println("Setup Method");

        AAAPattern = new AAAPattern();
    }

    @After
    public void tearDown() {

        System.out.println("Teardown Method");
    }

    @Test
    public void testAdd() {
        int a = 10;
        int b = 20;
        int result = AAAPattern.add(a, b);
        assertEquals(30, result);
    }
}