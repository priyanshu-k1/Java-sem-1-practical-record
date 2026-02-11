//Write a program to perform Transaction Management on Database (Batch Update)
import java.sql.*;

public class Prg18 {
    static final String URL = "jdbc:mysql://localhost:3306/users";
    static final String USER = "root";
    static final String PASSWORD = "1903@kp";


    static void retrieveRecords(Connection con,Statement st) throws SQLException {
        String query = "SELECT * FROM student";
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            System.out.println(rs.getString("name") + " " + rs.getInt("roll_no") + " " + rs.getString("course"));
        }
    }

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
            con.setAutoCommit(false);

            Statement st = con.createStatement();

            st.addBatch("INSERT INTO student(name, roll_no, course) VALUES('sultan',202, 'MCA')");
            st.addBatch("INSERT INTO student(name, roll_no, course) VALUES('Arjun Reddy',203, 'MCA')");
            
            System.out.println("\nBefore Batch Execution:");
            retrieveRecords(con,st);
            st.addBatch("UPDATE student SET course='MBA' WHERE roll_no=203");
            st.addBatch("DELETE FROM student WHERE roll_no=202");
            
            System.out.println("\nAfter Batch Execution:");
            retrieveRecords(con,st);
            st.executeBatch();
            con.commit();

            st.close();
            con.close();
        } catch (Exception e) {
           System.out.println(e.toString());
        }
    }
}
