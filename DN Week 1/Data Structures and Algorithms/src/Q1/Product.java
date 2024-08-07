package Q1;

import java.util.HashMap;

class Product {
    private String productId;
    private String productName;
    private int quantity;
    private double price;
    private static HashMap<String, Product> inventory = new HashMap<>();

    public Product(String productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Q1.Product{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }


    public static void addProduct(Product product) {
        inventory.put(product.getProductId(), product);
    }

    public static void updateProduct(String productId, Product product) {
        inventory.put(productId, product);
    }

    public static void deleteProduct(String productId) {
        inventory.remove(productId);
    }

    public static Product getProduct(String productId) {
        return inventory.get(productId);
    }

    public static void displayAllProducts() {
        for (Product product : inventory.values()) {
            System.out.println(product);
        }
    }

    public static void main(String[] args) {
        // Add products
        Product product1 = new Product("001", "Q1.Product A", 100, 10.50);
        Product product2 = new Product("002", "Q1.Product B", 50, 20.00);
        Product.addProduct(product1);
        Product.addProduct(product2);

        Product.displayAllProducts();

        // Update a product
        Product updatedProduct = new Product("001", "Q1.Product A+", 150, 15.00);
        Product.updateProduct("001", updatedProduct);
        System.out.println("After update:");
        Product.displayAllProducts();

        // Delete a product
        Product.deleteProduct("002");
        System.out.println("After deletion:");
        Product.displayAllProducts();
    }
}
