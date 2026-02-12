//Write a program that connects to a database using JDBC and does add, delete, modify & retrieve operations.
import java.sql.*;

public class Prg16 {
    static final String URL = "jdbc:mysql://localhost:3306/users";
    static final String USER = "root";
    static final String PASSWORD = "1903@kp";

    static void addRecord(Connection con, String name, int roll, String course) throws SQLException {
        String query = "INSERT INTO student(name, roll_no, course) VALUES (?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, name);
        ps.setInt(2, roll);
        ps.setString(3, course);
        ps.executeUpdate();
        ps.close();
    }

    static void modifyRecord(Connection con, int roll, String name, String course) throws SQLException {
        String query = "UPDATE student SET name=?, course=? WHERE roll_no=?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, name);
        ps.setString(2, course);
        ps.setInt(3, roll);
        ps.executeUpdate();
        ps.close();
    }

    static void deleteRecord(Connection con, int roll) throws SQLException {
        String query = "DELETE FROM student WHERE roll_no=?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, roll);
        ps.executeUpdate();
        ps.close();
    }

    static void retrieveRecords(Connection con) throws SQLException {
        String query = "SELECT name, roll_no, course FROM student";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            System.out.println(rs.getString("name") + " " + rs.getInt("roll_no") + " " + rs.getString("course"));
        }
        rs.close();
        st.close();
    }

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);

            
            addRecord(con, "Pinky", 5, "MCA");

            modifyRecord(con, 5, "Pinky Ponky", "MCA");
            retrieveRecords(con);
            deleteRecord(con, 101);

            con.close();
        } catch (Exception e) {
           System.out.println(e.toString());
        }
    }
}
