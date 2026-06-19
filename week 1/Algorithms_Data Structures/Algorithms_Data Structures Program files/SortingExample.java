class Order {

    int orderId;
    String customerName;
    double totalPrice;
    Order(int orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }
    public void display() {
        System.out.println(orderId + "  " + customerName + "  Rs." + totalPrice);
    }
}
public class SortingExample {
    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (orders[j].totalPrice > orders[j + 1].totalPrice) {
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }
    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pivot = partition(orders, low, high);
            quickSort(orders, low, pivot - 1);
            quickSort(orders, pivot + 1, high);
        }
    }
    public static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].totalPrice;
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (orders[j].totalPrice < pivot) {
                i++;
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }
        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;
        return i + 1;
    }
    public static void displayOrders(Order[] orders) {
        for (Order order : orders) {
            order.display();
        }
    }
    public static void main(String[] args) {
        Order[] orders = {
                new Order(101, "Rahul", 2500),
                new Order(102, "Anjali", 8000),
                new Order(103, "Kiran", 1500),
                new Order(104, "Priya", 6000),
                new Order(105, "Amit", 4500)
        };
        bubbleSort(orders);
        System.out.println("Bubble Sort:");
        displayOrders(orders);
        Order[] orders2 = {
                new Order(101, "Rahul", 2500),
                new Order(102, "Anjali", 8000),
                new Order(103, "Kiran", 1500),
                new Order(104, "Priya", 6000),
                new Order(105, "Amit", 4500)
        };

        quickSort(orders2, 0, orders2.length - 1);

        System.out.println("\nQuick Sort:");
        displayOrders(orders2);
    }
}