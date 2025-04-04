import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductController {
    public static void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS Product ("
                + "ProductID INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "ProductName TEXT NOT NULL, "
                + "Price REAL NOT NULL, "
                + "Quantity INTEGER NOT NULL)";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void addProduct(Product product) {
        String sql = "INSERT INTO Product (ProductName, Price, Quantity) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            conn.setAutoCommit(false);
            pstmt.setString(1, product.getProductName());
            pstmt.setDouble(2, product.getPrice());
            pstmt.setInt(3, product.getQuantity());
            pstmt.executeUpdate();
            conn.commit();
            System.out.println("✅ Product added successfully!");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM Product";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                products.add(new Product(rs.getInt("ProductID"),
                        rs.getString("ProductName"),
                        rs.getDouble("Price"),
                        rs.getInt("Quantity")));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return products;
    }
}
