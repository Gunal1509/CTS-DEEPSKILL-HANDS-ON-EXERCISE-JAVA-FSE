class Product {

    int productId;
    String productName;
    String category;

    Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }
}
public class SearchExample {
    public static void linearSearch(Product[] products, int searchId) {
        for (Product p : products) {
            if (p.productId == searchId) {
                System.out.println("Linear Search");
                System.out.println("Product Found");
                System.out.println("ID       : " + p.productId);
                System.out.println("Name     : " + p.productName);
                System.out.println("Category : " + p.category);
                return;
            }
        }
        System.out.println("Product Not Found");
    }
    public static void binarySearch(Product[] products, int searchId) {
        int low = 0;
        int high = products.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (products[mid].productId == searchId) {
                System.out.println("\nBinary Search");
                System.out.println("Product Found");
                System.out.println("ID       : " + products[mid].productId);
                System.out.println("Name     : " + products[mid].productName);
                System.out.println("Category : " + products[mid].category);
                return;
            } else if (products[mid].productId < searchId) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println("Product Not Found");
    }
    public static void main(String[] args) {
        Product[] products = {
                new Product(101, "Laptop", "Electronics"),
                new Product(102, "Mouse", "Accessories"),
                new Product(103, "Keyboard", "Accessories"),
                new Product(104, "Monitor", "Electronics"),
                new Product(105, "Printer", "Electronics")
        };
        int searchId = 104;
        linearSearch(products, searchId);
        binarySearch(products, searchId);
    }
}