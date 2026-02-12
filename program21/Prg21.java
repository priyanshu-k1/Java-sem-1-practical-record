//Write a program to demonstrate request redirecting in Servlets.
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class Prg21  extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("second");
    }
    
}
