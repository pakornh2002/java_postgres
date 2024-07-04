import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://postgres:5432/testdb";
        String user = "testuser";
        String password = "testpassword";
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            // Establish connection to PostgreSQL
            conn = DriverManager.getConnection(url, user, password);
            
            // SQL statement to insert data into test_table
            String sql = "UPDATE test_table SET id = ? WHERE name = ?";
            
            // Prepare the SQL statement
            pstmt = conn.prepareStatement(sql);
            
            // Set parameters for the statement
            pstmt.setInt(1, 10);         
            pstmt.setString(2, "Hello World");  
            
            // Execute the SQL statement
            int rowsAffected = pstmt.executeUpdate();
            
            if (rowsAffected > 0) {
                System.out.println("Data updated successfully");
            } else {
                System.out.println("No rows affected, updating failed");
            }
            
        } catch (SQLException e) {
            // Print detailed SQL exception information
            System.err.println("SQL Error: " + e.getMessage());
        } finally {
            // Close PreparedStatement and Connection in finally block
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                // Print any SQLExceptions that occur during close operations
                System.err.println("Error closing resources: " + e.getMessage());
            }
        }
    }
}
