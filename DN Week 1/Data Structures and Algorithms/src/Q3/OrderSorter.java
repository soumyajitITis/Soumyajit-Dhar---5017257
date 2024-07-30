package Q3;
class Order {
    int orderId;
    String customerName;
    double totalPrice;

    public Order(int orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    public String toString() {
        return "Order ID: " + orderId + ", Customer: " + customerName + ", Total Price: $" + totalPrice;
    }
}

public class OrderSorter {
    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (orders[j].totalPrice > orders[j + 1].totalPrice) {
                    // Swap orders[j] and orders[j + 1]
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break; // Optimization: Stop if no swaps occurred
        }
    }

    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);
            quickSort(orders, low, pi - 1);
            quickSort(orders, pi + 1, high);
        }
    }

    private static int partition(Order[] orders, int low, int high) {
        Order pivot = orders[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (orders[j].totalPrice < pivot.totalPrice) {
                i++;
                // Swap orders[i] and orders[j]
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

    public static void main(String[] args) {
        Order[] orders = {
                new Order(1, "Alice", 250.0),
                new Order(2, "Bob", 150.0),
                new Order(3, "Charlie", 300.0),
                new Order(4, "Dave", 200.0)
        };

        System.out.println("Original Orders:");
        for (Order order : orders) {
            System.out.println(order);
        }

        bubbleSort(orders);
        System.out.println("\nOrders Sorted by Bubble Sort:");
        for (Order order : orders) {
            System.out.println(order);
        }

        // Resetting order for quick sort
        orders = new Order[]{
                new Order(1, "Alice", 250.0),
                new Order(2, "Bob", 150.0),
                new Order(3, "Charlie", 300.0),
                new Order(4, "Dave", 200.0)
        };

        quickSort(orders, 0, orders.length - 1);
        System.out.println("\nOrders Sorted by Quick Sort:");
        for (Order order : orders) {
            System.out.println(order);
        }
    }
}

