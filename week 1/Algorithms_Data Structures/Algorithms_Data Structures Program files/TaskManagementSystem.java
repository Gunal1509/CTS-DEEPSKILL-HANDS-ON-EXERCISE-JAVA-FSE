class Task {

    int taskId;
    String taskName;
    String status;

    Task next;

    Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
        this.next = null;
    }
}

public class TaskManagementSystem {

    static Task head = null;
    static void addTask(int id, String name, String status) {

        Task newTask = new Task(id, name, status);

        if (head == null) {
            head = newTask;
        } else {

            Task temp = head;

            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = newTask;
        }
        System.out.println("Task Added");
    }
    static void searchTask(int id) {
        Task temp = head;
        while (temp != null) {
            if (temp.taskId == id) {
                System.out.println("Task Found");
                System.out.println(temp.taskId + " " + temp.taskName + " " + temp.status);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Task Not Found");
    }
    static void displayTasks() {
        Task temp = head;
        System.out.println("\nTask List");
        while (temp != null) {
            System.out.println(temp.taskId + " " + temp.taskName + " " + temp.status);
            temp = temp.next;
        }
    }
    static void deleteTask(int id) {

        if (head == null) {
            System.out.println("List is Empty");
            return;
        }
        if (head.taskId == id) {

            head = head.next;
            System.out.println("Task Deleted");
            return;
        }
        Task temp = head;

        while (temp.next != null && temp.next.taskId != id) {
            temp = temp.next;
        }
        if (temp.next == null) {
            System.out.println("Task Not Found");
        } else {

            temp.next = temp.next.next;
            System.out.println("Task Deleted");
        }
    }
    public static void main(String[] args) {

        addTask(1, "Design UI", "Pending");
        addTask(2, "Write Code", "In Progress");
        addTask(3, "Testing", "Pending");

        displayTasks();

        System.out.println();

        searchTask(2);

        System.out.println();

        deleteTask(1);

        displayTasks();
    }
}