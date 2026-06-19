class Employee {
    int employeeId;
    String name;
    String position;
    double salary;
    Employee(int employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }
    public void display() {
        System.out.println(employeeId + " " + name + " " + position + " Rs." + salary);
    }
}
public class EmployeeManagementSystem {
    static Employee[] employees = new Employee[5];
    static int count = 0;
    static void addEmployee(Employee emp) {

        if (count < employees.length) {
            employees[count] = emp;
            count++;
            System.out.println("Employee Added");
        } else {
            System.out.println("Array is Full");
        }
    }
    static void searchEmployee(int id) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == id) {
                System.out.println("Employee Found");
                employees[i].display();
                return;
            }
        }
        System.out.println("Employee Not Found");
    }
    static void displayEmployees() {
        System.out.println("\nEmployee List");
        for (int i = 0; i < count; i++) {
            employees[i].display();
        }
    }
    static void deleteEmployee(int id) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == id) {
                for (int j = i; j < count - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[count - 1] = null;
                count--;
                System.out.println("Employee Deleted");
                return;
            }
        }
        System.out.println("Employee Not Found");
    }
    public static void main(String[] args) {
        addEmployee(new Employee(101, "Rahul", "Manager", 60000));
        addEmployee(new Employee(102, "Priya", "Developer", 50000));
        addEmployee(new Employee(103, "Kiran", "Tester", 45000));
        displayEmployees();
        System.out.println();
        searchEmployee(102);
        System.out.println();
        deleteEmployee(101);
        displayEmployees();
    }
}