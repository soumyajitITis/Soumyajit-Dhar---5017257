package Q2;

import java.util.Arrays;

class Product implements Comparable<Product> {
    private String productId;
    private String productName;
    private String category;

    public Product(String productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", category='" + category + '\'' +
                '}';
    }

    @Override
    public int compareTo(Product other) {
        return this.productId.compareTo(other.productId);
    }

    public static Product linearSearch(Product[] products, String productId) {
        for (Product product : products) {
            if (product.getProductId().equals(productId)) {
                return product;
            }
        }
        return null;
    }

    public static Product binarySearch(Product[] products, String productId) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = products[mid].getProductId().compareTo(productId);

            if (comparison == 0) {
                return products[mid];
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Product[] products = {
                new Product("003", "Product C", "Category 1"),
                new Product("001", "Product A", "Category 1"),
                new Product("002", "Product B", "Category 2")
        };

        // Linear search
        Product foundProduct = linearSearch(products, "002");
        System.out.println("Linear Search Result: " + (foundProduct != null ? foundProduct : "Product not found"));

        // Sort the products array for binary search
        Arrays.sort(products);

        // Binary search
        foundProduct = binarySearch(products, "002");
        System.out.println("Binary Search Result: " + (foundProduct != null ? foundProduct : "Product not found"));
    }
}

