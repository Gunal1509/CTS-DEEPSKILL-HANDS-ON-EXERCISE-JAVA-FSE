class Student {

    private int id;
    private String name;
    private String grade;

    public Student(int id, String name, String grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
class StudentView {

    public void displayStudentDetails(Student student) {

        System.out.println("Student Details");
        System.out.println("ID    : " + student.getId());
        System.out.println("Name  : " + student.getName());
        System.out.println("Grade : " + student.getGrade());
    }
}
class StudentController {

    private Student model;
    private StudentView view;

    public StudentController(Student model, StudentView view) {
        this.model = model;
        this.view = view;
    }

    public void setStudentName(String name) {
        model.setName(name);
    }

    public void setStudentGrade(String grade) {
        model.setGrade(grade);
    }

    public void updateView() {
        view.displayStudentDetails(model);
    }
}
public class MVCPatternExample {

    public static void main(String[] args) {

        Student student = new Student(101, "Sanjay", "A");
        StudentView view = new StudentView();
        StudentController controller =
                new StudentController(student, view);
        System.out.println("Initial Details");
        controller.updateView();
        System.out.println();
        controller.setStudentName("Rahul");
        controller.setStudentGrade("A+");
        System.out.println("Updated Details");
        controller.updateView();
    }
}