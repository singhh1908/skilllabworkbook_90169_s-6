package com.curdop;

import com.curdop.dao.ProductDAO;
import com.curdop.entity.Product;
import com.curdop.util.HibernateUtil;

import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        ProductDAO dao = new ProductDAO();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Retail Inventory (Hibernate CRUD) ===");
            System.out.println("1. Insert sample products");
            System.out.println("2. Add new product");
            System.out.println("3. Get product by ID");
            System.out.println("4. View all products");
            System.out.println("5. Update price/quantity");
            System.out.println("6. Delete product by ID");
            System.out.println("7. ID Strategy Demo (AUTO/IDENTITY/SEQUENCE)");
            System.out.println("0. Exit");
            System.out.print("Choose: ");

            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine().trim());
            } catch (Exception e) {
                System.out.println("Invalid input. Try again.");
                continue;
            }

            switch (choice) {
                case 1 -> {
                    dao.addProduct(new Product("Laptop", "Dell i5 12th Gen", 55000, 10));
                    dao.addProduct(new Product("Mouse", "Wireless Mouse", 500, 50));
                    dao.addProduct(new Product("Keyboard", "Mechanical Keyboard", 2500, 20));
                    System.out.println("Inserted sample products ✅");
                }
                case 2 -> {
                    System.out.print("Name: ");
                    String name = sc.nextLine();

                    System.out.print("Description: ");
                    String desc = sc.nextLine();

                    System.out.print("Price: ");
                    double price = Double.parseDouble(sc.nextLine());

                    System.out.print("Quantity: ");
                    int qty = Integer.parseInt(sc.nextLine());

                    Long id = dao.addProduct(new Product(name, desc, price, qty));
                    System.out.println("Inserted with ID: " + id);
                }
                case 3 -> {
                    System.out.print("Enter ID: ");
                    Long id = Long.parseLong(sc.nextLine());
                    Product p = dao.getProductById(id);
                    System.out.println(p != null ? p : "Product not found ❌");
                }
                case 4 -> {
                    List<Product> list = dao.getAllProducts();
                    if (list.isEmpty()) System.out.println("No products found.");
                    else list.forEach(System.out::println);
                }
                case 5 -> {
                    System.out.print("Enter ID: ");
                    Long id = Long.parseLong(sc.nextLine());

                    System.out.print("New Price (or blank to skip): ");
                    String priceStr = sc.nextLine();
                    Double price = priceStr.isBlank() ? null : Double.parseDouble(priceStr);

                    System.out.print("New Quantity (or blank to skip): ");
                    String qtyStr = sc.nextLine();
                    Integer qty = qtyStr.isBlank() ? null : Integer.parseInt(qtyStr);

                    boolean ok = dao.updateProduct(id, price, qty);
                    System.out.println(ok ? "Updated ✅" : "Product not found ❌");
                }
                case 6 -> {
                    System.out.print("Enter ID to delete: ");
                    Long id = Long.parseLong(sc.nextLine());
                    boolean ok = dao.deleteProduct(id);
                    System.out.println(ok ? "Deleted ✅" : "Product not found ❌");
                }
                case 7 -> StrategyDemo.runOnce();
                case 0 -> {
                    sc.close();
                    HibernateUtil.shutdown();
                    System.out.println("Bye 👋");
                    return;
                }
                default -> System.out.println("Invalid choice ❌");
            }
        }
    }
}
