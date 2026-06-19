import java.util.HashMap;
class Product {

    private int productId;
    private String productName;
    private int quantity;
    private double price;
	public Product(int productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }
	public int getProductId() {
        return productId;
    }
	public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
	public void setPrice(double price) {
        this.price = price;
    }
	public void display() {
        System.out.println("ID : " + productId);
        System.out.println("Name : " + productName);
        System.out.println("Quantity : " + quantity);
        System.out.println("Price : Rs." + price);
        System.out.println();
    }
}
class Inventory {

    private HashMap<Integer, Product> products = new HashMap<>();

    public void addProduct(Product product) {

        products.put(product.getProductId(), product);

        System.out.println("Product Added");
    }
    public void updateProduct(int id, int quantity, double price) {

        Product product = products.get(id);
		if(product != null) {
			product.setQuantity(quantity);
            product.setPrice(price);
			System.out.println("Product Updated");
        } else {

            System.out.println("Product Not Found");
        }
    }
    public void deleteProduct(int id) {
		if(products.remove(id) != null) {
			System.out.println("Product Deleted");
        } else {
			System.out.println("Product Not Found");
        }
    }
    public void displayProducts() {

        for(Product product : products.values()) {
			product.display();
        }
    }
}
public class InventoryManagementSystem {

    public static void main(String[] args) {

        Inventory inventory = new Inventory();

        Product p1 = new Product(101,"Laptop",10,55000);

        Product p2 = new Product(102,"Mouse",25,700);

        inventory.addProduct(p1);

        inventory.addProduct(p2);

        System.out.println();

        inventory.displayProducts();

        inventory.updateProduct(101,15,53000);

        System.out.println();

        inventory.displayProducts();

        inventory.deleteProduct(102);

        System.out.println();

        inventory.displayProducts();

    }
}