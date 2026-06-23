package junit_exercises;

import org.junit.Test;
import static org.junit.Assert.*;

public class StudentTest {

    @Test
    public void testPass() {

        Student s = new Student();

        assertEquals("Pass", s.getGrade(80));
    }

    @Test
    public void testFail() {

        Student s = new Student();

        assertEquals("Fail", s.getGrade(30));
    }
}
