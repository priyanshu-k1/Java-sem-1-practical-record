//Write a program (Servlet) that connects to database to validate username & password.
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Prg20 extends HttpServlet{
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/users", "root", "1903@kp");

            PreparedStatement ps = con.prepareStatement(
                    "SELECT * FROM login WHERE username=? AND password=?");

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                out.println("<h2>Login Successful</h2>");
            } else {
                out.println("<h2>Invalid Username or Password</h2>");
            }

            con.close();

        } catch (Exception e) {
            out.println(e);
        }
    }
    
}


