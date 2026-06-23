

package junit_exercises;

public class Student {

    public String getGrade(int marks) {

        if (marks >= 50)
            return "Pass";
        else
            return "Fail";
    }
}