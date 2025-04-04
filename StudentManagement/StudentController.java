import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentController {
    public static void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS Student ("
                + "StudentID INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "Name TEXT NOT NULL, "
                + "Department TEXT NOT NULL, "
                + "Marks REAL NOT NULL)";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void addStudent(Student student) {
        String sql = "INSERT INTO Student (Name, Department, Marks) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, student.getName());
            pstmt.setString(2, student.getDepartment());
            pstmt.setDouble(3, student.getMarks());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
