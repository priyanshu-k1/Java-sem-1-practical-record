//Write a program to call functions / procedures on database.

import java.sql.*;

public class Prg17 {
    static final String URL = "jdbc:mysql://localhost:3306/users";
    static final String USER = "root";
    static final String PASSWORD = "1903@kp";

    public static void callProcedure(Connection con, String name, int roll, String course) throws SQLException {
        CallableStatement cs = con.prepareCall("{call add_student(?, ?, ?)}");
        cs.setString(1, name);
        cs.setInt(2, roll);
        cs.setString(3, course);
        cs.execute();
        cs.close();
    }

    public static void callFunction(Connection con, int roll) throws SQLException {
        CallableStatement cs = con.prepareCall("{? = call get_course(?)}");
        cs.registerOutParameter(1, Types.VARCHAR);
        cs.setInt(2, roll);
        cs.execute();
        String course = cs.getString(1);
        System.out.println("Course for roll number " + roll + ": " + course);
        cs.close();
    }

    public static void main(String[] args) throws Exception {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);

            callProcedure(con, "Rahul", 133, "MCA");
            callFunction(con, 133);

            con.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
