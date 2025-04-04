import java.util.Scanner;

public class ProductCRUD {
    public static void main(String[] args) {
        ProductController.createTable();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Product\n2. View Products\n3. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Product Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Price: ");
                    double price = scanner.nextDouble();
                    System.out.print("Enter Quantity: ");
                    int qty = scanner.nextInt();
                    ProductController.addProduct(new Product(0, name, price, qty));
                    break;
                case 2:
                    for (Product p : ProductController.getAllProducts()) {
                        System.out.printf("ID: %d | Name: %s | Price: $%.2f | Quantity: %d%n",
                                p.getProductId(), p.getProductName(), p.getPrice(), p.getQuantity());
                    }
                    break;
                case 3:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
